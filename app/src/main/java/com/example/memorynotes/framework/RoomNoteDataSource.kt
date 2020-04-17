package com.example.memorynotes.framework

import android.content.Context
import com.example.core.data.Note
import com.example.core.repository.NoteDataSource
import com.example.memorynotes.framework.db.DatabaseService
import com.example.memorynotes.framework.db.NoteEntity
import kotlinx.coroutines.flow.*

class RoomNoteDataSource(context: Context): NoteDataSource {

    private val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long): Flow<Note?> = noteDao.getNoteEntity(id).map{ it?.toNote() }

    override suspend fun getAll(): Flow<List<Note>> = noteDao.getAllNoteEntities().map { flowNote -> flowNote.map { it.toNote() } }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}