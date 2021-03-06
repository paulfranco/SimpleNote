package co.paulfran.paulfranco.simplenote.framework.di

import co.paulfran.paulfranco.core.repository.NoteRepository
import co.paulfran.paulfranco.core.usecase.*
import co.paulfran.paulfranco.simplenote.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
        GetWordCount()
    )

}