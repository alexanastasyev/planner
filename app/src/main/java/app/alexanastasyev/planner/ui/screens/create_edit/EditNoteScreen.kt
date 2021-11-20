package app.alexanastasyev.planner.ui.screens.create_edit

import android.view.View
import android.widget.TextView
import app.alexanastasyev.planner.domain.Note
import app.alexanastasyev.planner.domain.Priority
import app.alexanastasyev.planner.utils.NotesRepository

class EditNoteScreen : AbstractCreateEditScreen() {
    override fun fillViews() {
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

    override fun setOnButtonSaveClickListener() {
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