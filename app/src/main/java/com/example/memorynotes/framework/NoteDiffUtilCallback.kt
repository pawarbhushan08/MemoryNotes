package com.example.memorynotes.framework

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.example.core.data.Note


class NoteDiffUtilCallback(
    oldNoteList: List<Note>,
    newNoteList: List<Note>
) :
    DiffUtil.Callback() {
    private val mOldNoteList: List<Note> = oldNoteList
    private val mNewNoteList: List<Note> = newNoteList
    override fun getOldListSize(): Int {
        return mOldNoteList.size
    }

    override fun getNewListSize(): Int {
        return mNewNoteList.size
    }

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return mOldNoteList[oldItemPosition].id == mNewNoteList[newItemPosition].id
    }

    override fun areContentsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        val oldNote: Note = mOldNoteList[oldItemPosition]
        val newNote: Note = mNewNoteList[newItemPosition]
        return oldNote.content == newNote.content && oldNote.title == newNote.title
    }


    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}