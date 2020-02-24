package co.paulfran.paulfranco.simplenote.framework.di

import co.paulfran.paulfranco.simplenote.framework.ListViewModel
import co.paulfran.paulfranco.simplenote.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}