package co.paulfran.paulfranco.core.usecase

import co.paulfran.paulfranco.core.repository.NoteRepository

class GetAllNotes(private val noteRepository: NoteRepository) {

    suspend operator fun invoke() = noteRepository.getAllNotes()

}