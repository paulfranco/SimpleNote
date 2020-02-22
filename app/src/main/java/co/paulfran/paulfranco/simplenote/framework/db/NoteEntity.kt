package co.paulfran.paulfranco.simplenote.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import co.paulfran.paulfranco.core.data.Note

@Entity(tableName = "note")
data class NoteEntity(
    val title: String,
    val content: String,
    @ColumnInfo(name = "creation_date")
    val creationTime: Long,
    @ColumnInfo(name = "update_time")
    val updateTime: Long,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
) {
    // Create NoteEntity from a Core/Data/Note
    companion object {
        fun fromNote(note: Note) = NoteEntity(note.title, note.content, note.creationTime, note.updateTime)
    }
    // Create a Note from a NoteEntity
    fun toNote() = Note(title, content, creationTime, updateTime, id)
}