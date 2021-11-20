package app.alexanastasyev.planner.ui.screens.create_edit

import app.alexanastasyev.planner.domain.Note
import app.alexanastasyev.planner.domain.Priority

open class CreateNoteScreen : AbstractCreateEditScreen() {

    override fun fillViews() {
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
                time
            } else {
                null
            }
            presenter.save(
                Note(
                    text = text,
                    date = date,
                    priority = priority
                )
            )
        }
    }
}