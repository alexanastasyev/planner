package app.alexanastasyev.planner.ui.screens.create

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import app.alexanastasyev.planner.MainActivity
import app.alexanastasyev.planner.databinding.ScreenCreateNoteBinding

class CreateNoteScreen : Fragment(), CreateNoteView {
    private lateinit var binding: ScreenCreateNoteBinding
    private val presenter = CreateNotePresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ScreenCreateNoteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.init()
        setOnCheckBoxTimeListener()
    }

    private fun setOnCheckBoxTimeListener() {
        binding.checkBoxTime.setOnClickListener {
            if ((it as CheckBox).isChecked) {
                showDatePicker()
            } else {
                hideDatePicker()
            }
        }
    }

    private fun showDatePicker() {
        binding.datePicker.visibility = View.VISIBLE
    }

    private fun hideDatePicker() {
        binding.datePicker.visibility = View.GONE
    }

    override fun setTitle(title: String) {
        (activity as MainActivity).setActionBarTitle(title)
    }

    override fun provideContext(): Context {
        return requireContext()
    }
}