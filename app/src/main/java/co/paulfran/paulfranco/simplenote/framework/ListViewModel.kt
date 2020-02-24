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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(application: Application): AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val repository = NoteRepository(RoomNoteDataSource(application))

    val useCases = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository)
    )

    val notes = MutableLiveData<List<Note>>()

    fun getNotes() {
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            notes.postValue(noteList)
        }
    }

}