package co.paulfran.paulfranco.core.usecase

import co.paulfran.paulfranco.core.data.Note
import co.paulfran.paulfranco.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)

}