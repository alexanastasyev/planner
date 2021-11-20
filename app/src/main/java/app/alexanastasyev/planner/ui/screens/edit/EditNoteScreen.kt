package app.alexanastasyev.planner.ui.screens.edit

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.domain.Note
import app.alexanastasyev.planner.domain.Priority
import app.alexanastasyev.planner.ui.screens.create.CreateNoteScreen
import app.alexanastasyev.planner.utils.NavigationUtils
import app.alexanastasyev.planner.utils.NotesRepository

class EditNoteScreen : CreateNoteScreen() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setTitle(getString(R.string.edit_note))
        fillViews()
        changeButtonClickListener()
    }

    private fun fillViews() {
        val note = NotesRepository.getCurrentNote()
        binding.editTextNoteText.setText(note.text, TextView.BufferType.EDITABLE)
        note.date?.let { date ->
            this.time = date
            this.initTime()
            binding.checkBoxTime.isChecked = true
            binding.textViewTime.visibility = View.VISIBLE
        }
        when (note.priority) {
            Priority.LOW -> binding.radioButtonLow.isChecked = true
            Priority.MEDIUM -> binding.radioButtonMedium.isChecked = true
            Priority.HIGH -> binding.radioButtonHigh.isChecked = true
        }
    }

    private fun changeButtonClickListener() {
        binding.buttonSave.setOnClickListener {
            val text = binding.editTextNoteText.text.toString()
            val priority = when {
                binding.radioButtonLow.isChecked -> Priority.LOW
                binding.radioButtonMedium.isChecked -> Priority.MEDIUM
                binding.radioButtonHigh.isChecked -> Priority.HIGH
                else -> Priority.MEDIUM
            }
            val date = if (binding.checkBoxTime.isChecked) {
                this.time
            } else {
                null
            }
            val note = Note(
                text = text,
                date = date,
                priority = priority
            )
            note.id = NotesRepository.getCurrentNote().id
            presenter.save(note)
        }
    }
}