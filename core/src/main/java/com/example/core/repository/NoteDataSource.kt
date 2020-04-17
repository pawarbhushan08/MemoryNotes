package com.example.core.repository

import com.example.core.data.Note
import kotlinx.coroutines.flow.*

interface NoteDataSource {
    // suspend for Coroutines
    suspend fun add( note: Note)

    suspend fun get(id: Long): Flow<Note?>

    suspend fun getAll(): Flow<List<Note>>

    suspend fun remove(note: Note)
}