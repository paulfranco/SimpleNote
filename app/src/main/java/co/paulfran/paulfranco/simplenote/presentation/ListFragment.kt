package co.paulfran.paulfranco.simplenote.presentation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import co.paulfran.paulfranco.simplenote.R
import co.paulfran.paulfranco.simplenote.framework.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(), ListAction {

    private val notesListAdapter= NotesListAdapter(arrayListOf(), this)
    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesListView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = notesListAdapter

        }

        // Add functionality to the FOB to go to NoteDetail Fragment
        addNote.setOnClickListener { goToNoteDetails() }

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        observeViewModel()
    }

    private fun goToNoteDetails(id: Long = 0L) {
        val action = ListFragmentDirections.goToNote(id)
        Navigation.findNavController(notesListView).navigate(action)
    }

    fun observeViewModel() {
        viewModel.notes.observe(this, Observer {notesList ->
            loadingView.visibility = View.GONE
            notesListView.visibility = View.VISIBLE
            notesListAdapter.updateNotes(notesList.sortedByDescending { it.updateTime })
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNotes()
    }

    override fun onClick(id: Long) {
        goToNoteDetails(id)
    }

}
