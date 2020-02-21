package co.paulfran.paulfranco.core.usecase

import co.paulfran.paulfranco.core.data.Note
import co.paulfran.paulfranco.core.repository.NoteRepository

class RemoveNote(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(note: Note) = noteRepository.removeNote(note)

}