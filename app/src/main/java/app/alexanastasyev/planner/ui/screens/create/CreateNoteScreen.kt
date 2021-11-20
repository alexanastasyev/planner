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
import app.alexanastasyev.planner.utils.DateFormatter
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.utils.NavigationUtils

open class CreateNoteScreen : Fragment(), CreateNoteView {
    companion object {
        private const val DATE_TIME_FORMAT = "dd.MM.yyyy, HH:mm"
    }

    protected lateinit var binding: ScreenCreateNoteBinding
    protected val presenter = CreateNotePresenter(this)
    protected var time = System.currentTimeMillis()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ScreenCreateNoteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.init()
        initTime()
        setOnCheckBoxTimeListener()
        setOnTimeClickListener()
        setOnButtonSaveClickListener()
    }

    protected fun initTime() {
        binding.textViewTime.text = DateFormatter.formatDate(time, DATE_TIME_FORMAT)
    }

    private fun setOnCheckBoxTimeListener() {
        binding.checkBoxTime.setOnClickListener {
            if ((it as CheckBox).isChecked) {
                showTime()
            } else {
                hideTime()
            }
        }
    }

    private fun showTime() {
        binding.textViewTime.visibility = View.VISIBLE
    }

    private fun hideTime() {
        binding.textViewTime.visibility = View.INVISIBLE
    }

    private fun setOnTimeClickListener() {
        binding.textViewTime.setOnClickListener {
            NavigationUtils.onTimeSelected = { time ->
                this.time = time
                initTime()
            }
            NavigationUtils.currentTime = this.time
            findNavController().navigate(R.id.dateTimePickerDialog)
        }
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

    override fun setTitle(title: String) {
        (activity as MainActivity).setActionBarTitle(title)
    }

    override fun provideContext(): Context {
        return requireContext()
    }

    override fun provideNavController(): NavController {
        return findNavController()
    }

    override fun showMessage(text: String) {
        Snackbar.make(binding.root, text, Snackbar.LENGTH_SHORT).show()
    }
}