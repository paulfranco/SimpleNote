package co.paulfran.paulfranco.simplenote.framework

import co.paulfran.paulfranco.core.usecase.AddNote
import co.paulfran.paulfranco.core.usecase.GetAllNotes
import co.paulfran.paulfranco.core.usecase.GetNote
import co.paulfran.paulfranco.core.usecase.RemoveNote

// Allows is to instatiate all of the use cases and use them in our viewModel allowing us to inject them where we need them
data class UseCases(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote
    )