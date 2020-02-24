package co.paulfran.paulfranco.simplenote.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import co.paulfran.paulfranco.core.data.Note
import co.paulfran.paulfranco.core.repository.NoteRepository
import co.paulfran.paulfranco.core.usecase.AddNote
import co.paulfran.paulfranco.core.usecase.GetAllNotes
import co.paulfran.paulfranco.core.usecase.GetNote
import co.paulfran.paulfranco.core.usecase.RemoveNote
import co.paulfran.paulfranco.simplenote.framework.di.ApplicationModule
import co.paulfran.paulfranco.simplenote.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteViewModel(application: Application): AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    val saved = MutableLiveData<Boolean>()

    val currentNote = MutableLiveData<Note?>()

    fun savedNote(note: Note) {
        coroutineScope.launch {
            useCases.addNote(note)
            saved.postValue(true)
        }
    }

    fun getNote(id: Long) {
        coroutineScope.launch {
            val note = useCases.getNote(id)
            currentNote.postValue(note)
        }
    }

    fun deleteNote(note: Note) {
        coroutineScope.launch {
            useCases.removeNote(note)
            saved.postValue(true)
        }
    }
}