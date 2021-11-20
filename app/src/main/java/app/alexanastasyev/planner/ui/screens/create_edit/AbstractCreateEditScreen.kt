package app.alexanastasyev.planner.ui.screens.create_edit

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import app.alexanastasyev.planner.MainActivity
import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.databinding.ScreenCreateEditNoteBinding
import app.alexanastasyev.planner.utils.DateFormatter
import app.alexanastasyev.planner.utils.NavigationUtils
import com.google.android.material.snackbar.Snackbar

abstract class AbstractCreateEditScreen : Fragment(), CreateEditView {
    companion object {
        private const val DATE_TIME_FORMAT = "dd.MM.yyyy, HH:mm"
    }

    protected lateinit var binding: ScreenCreateEditNoteBinding
    protected val presenter = CreateEditPresenter(this)
    protected var time = System.currentTimeMillis()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ScreenCreateEditNoteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.init()
        fillViews()
        initTime()
        setOnCheckBoxTimeListener()
        setOnTimeClickListener()
        setOnButtonSaveClickListener()
    }

    abstract fun fillViews()
    abstract fun setOnButtonSaveClickListener()

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