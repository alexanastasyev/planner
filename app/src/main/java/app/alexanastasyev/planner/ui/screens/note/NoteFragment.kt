package app.alexanastasyev.planner.ui.screens.note

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import app.alexanastasyev.planner.App
import app.alexanastasyev.planner.ui.MainActivity
import app.alexanastasyev.planner.databinding.ScreenNoteBinding
import javax.inject.Inject

class NoteFragment : Fragment(), NoteView {

    @Inject
    lateinit var noteComponentBuilder: NoteComponent.Builder

    private lateinit var presenter: NotePresenter

    private lateinit var binding: ScreenNoteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ScreenNoteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.injectNoteScreen(this)
        presenter = noteComponentBuilder.view(this).build().getNotePresenter()

        setOnDeleteClickListener()
        setOnEditClickListener()
        presenter.init()
    }

    private fun setOnDeleteClickListener() {
        binding.buttonDeleteNote.setOnClickListener {
            presenter.deleteClicked()
        }
    }

    private fun setOnEditClickListener() {
        binding.buttonEditNote.setOnClickListener {
            presenter.editClicked()
        }
    }

    override fun showText(text: String) {
        binding.textViewNoteText.text = text
    }

    override fun showDate(date: String) {
        binding.textViewNoteDate.text = date
    }

    override fun showTime(time: String) {
        binding.textViewNoteTime.text = time
    }

    override fun provideContext(): Context {
        return requireContext()
    }

    override fun provideNavController(): NavController {
        return findNavController()
    }

    override fun setTitle(title: String) {
        (activity as MainActivity).setActionBarTitle(title)
    }
}