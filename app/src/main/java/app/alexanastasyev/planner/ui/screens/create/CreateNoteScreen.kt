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
import app.alexanastasyev.planner.domain.Note
import app.alexanastasyev.planner.domain.Priority
import com.google.android.material.snackbar.Snackbar
import java.util.*

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
        setOnCheckBoxDateListener()
        setOnButtonSaveClickListener()
    }

    private fun setOnCheckBoxDateListener() {
        binding.checkBoxDate.setOnClickListener {
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

    private fun setOnButtonSaveClickListener() {
        binding.buttonSave.setOnClickListener {
            val text = binding.editTextNoteText.text.toString()
            val priority = when {
                binding.radioButtonLow.isChecked -> Priority.LOW
                binding.radioButtonMedium.isChecked -> Priority.MEDIUM
                binding.radioButtonHigh.isChecked -> Priority.HIGH
                else -> Priority.MEDIUM
            }
            val date = if (binding.checkBoxDate.isChecked) {
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.DAY_OF_MONTH, binding.datePicker.dayOfMonth)
                calendar.set(Calendar.MONTH, binding.datePicker.month)
                calendar.set(Calendar.YEAR, binding.datePicker.year)
                calendar.timeInMillis
            } else {
                null
            }
            presenter.saveNote(
                Note(
                    text = text,
                    date = date,
                    priority = priority
                )
            )
        }
    }

    override fun setTitle(title: String) {
        (activity as MainActivity).setActionBarTitle(title)
    }

    override fun provideContext(): Context {
        return requireContext()
    }

    override fun showMessage(text: String) {
        Snackbar.make(binding.root, text, Snackbar.LENGTH_SHORT).show()
    }
}