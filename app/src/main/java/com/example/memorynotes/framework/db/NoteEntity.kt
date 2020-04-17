package com.example.memorynotes.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.data.Note

@Entity(tableName = "note")
data class NoteEntity (
    val title: String,
    val content: String,

    @ColumnInfo(name = "creation_date")
    val creationTime: String,

    @ColumnInfo(name = "update_time")
    val updateTime: String,

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
) {
    companion object {
        fun fromNote(note: Note) = NoteEntity(note.title,note.content, note.creationTime.toString(), note.updateTime.toString(), note.id)
    }

    fun toNote() = Note(title, content, creationTime.toLong(), updateTime.toLong(), id)
}