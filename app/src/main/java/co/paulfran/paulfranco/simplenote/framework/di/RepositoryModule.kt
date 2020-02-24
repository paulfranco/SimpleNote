package co.paulfran.paulfranco.simplenote.framework.di

import android.app.Application
import co.paulfran.paulfranco.core.repository.NoteRepository
import co.paulfran.paulfranco.simplenote.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesRespository(app: Application) = NoteRepository(RoomNoteDataSource(app))

}