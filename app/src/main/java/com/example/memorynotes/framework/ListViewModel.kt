package com.example.memorynotes.framework

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.Note
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(private val useCases: UseCases) : ViewModel() {

    init {
        getNotes()
    }

    val notes = MutableLiveData<List<Note>>()

    private fun getNotes() {
        viewModelScope.launch {
            val noteList = useCases.getAllNotes()
            noteList.collect { notesList ->
                notesList.map { it.wordCount = getCount(it.title + it.content) }
                notes.postValue(notesList)
            }
        }
    }

    private fun getCount(str: String) =
        str.split(" ", "\n")
            .filter {
                it.contains(Regex(".*[a-z A-Z].*"))
            }
            .count()
}