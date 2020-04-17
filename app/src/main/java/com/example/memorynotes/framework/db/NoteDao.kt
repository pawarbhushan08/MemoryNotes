package com.example.memorynotes.framework.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
abstract class NoteDao {
    @Insert(onConflict = REPLACE)
    abstract fun addNoteEntity(noteEntity: NoteEntity)

    @Query("SELECT * FROM note WHERE id = :id")
    abstract fun getNoteEntity(id: Long): Flow<NoteEntity?>

    @Query("SELECT * FROM note")
    abstract fun getAllNoteEntities(): Flow<List<NoteEntity>>

    @Delete
    abstract fun deleteNoteEntity(noteEntity: NoteEntity)
}