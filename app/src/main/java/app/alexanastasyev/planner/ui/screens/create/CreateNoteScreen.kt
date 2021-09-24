package app.alexanastasyev.planner.ui.screens.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.alexanastasyev.planner.databinding.ScreenCreateNoteBinding

class CreateNoteScreen : Fragment(), CreateNoteView {
    private lateinit var binding: ScreenCreateNoteBinding
    private val presenter = CreateNotePresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ScreenCreateNoteBinding.inflate(inflater)
        return binding.root
    }
}