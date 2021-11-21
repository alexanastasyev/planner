package app.alexanastasyev.planner.ui.screens.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import app.alexanastasyev.planner.ui.MainActivity
import app.alexanastasyev.planner.databinding.ScreenHomeBinding
import app.alexanastasyev.planner.domain.Note
import com.google.android.material.snackbar.Snackbar

class HomeScreen : Fragment(), HomeView {

    private lateinit var binding: ScreenHomeBinding
    private val presenter = HomePresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ScreenHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.init()
    }

    override fun setTitle(title: String) {
        (activity as MainActivity).setActionBarTitle(title)
    }

    override fun provideContext(): Context {
        return requireContext()
    }

    override fun provideNavController(): NavController {
        return findNavController()
    }

    override fun showNotes(notes: List<Note>) {
        binding.recyclerViewNotes.adapter = NotesAdapter(notes) { position ->
            presenter.noteClicked(position)
        }
        binding.recyclerViewNotes.visibility = View.VISIBLE
        binding.progressBarHome.visibility = View.INVISIBLE
    }

    override fun showError(text: String) {
        Snackbar.make(binding.root, text, Snackbar.LENGTH_SHORT).show()
    }
}