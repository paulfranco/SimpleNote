package co.paulfran.paulfranco.simplenote.framework

import android.content.Context
import co.paulfran.paulfranco.core.data.Note
import co.paulfran.paulfranco.core.repository.NoteDataSource
import co.paulfran.paulfranco.simplenote.framework.db.DatabaseService
import co.paulfran.paulfranco.simplenote.framework.db.NoteEntity

class RoomNoteDataSource(context: Context): NoteDataSource {

    // This is how we access the database
    val noteDao = DatabaseService.getInstance(context).noteDao()

    // Get note from Core/Data/Note to convert to a NoteEntity
    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.toNote()

    // This returns a list this is why we .map
    override suspend fun getAll() = noteDao.getAllNoteEntities().map { it.toNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))


}