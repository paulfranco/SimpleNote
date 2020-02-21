package co.paulfran.paulfranco.core.usecase

import co.paulfran.paulfranco.core.repository.NoteRepository

class GetNote(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(id: Long) = noteRepository.getNote(id)

}