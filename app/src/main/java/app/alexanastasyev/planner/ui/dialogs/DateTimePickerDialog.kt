package app.alexanastasyev.planner.ui.dialogs

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.databinding.DialogDateTimeBinding
import app.alexanastasyev.planner.utils.NavigationUtils
import java.util.*

class DateTimePickerDialog : DialogFragment() {
    private lateinit var binding: DialogDateTimeBinding

    override fun getTheme() = R.style.RoundedCornersDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DialogDateTimeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.timePicker.setIs24HourView(true)
        initPickers()
        setOnButtonSaveClickListener()
    }

    private fun initPickers() {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = NavigationUtils.currentTime
        binding.datePicker.updateDate(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.timePicker.minute = calendar.get(Calendar.MINUTE)
            binding.timePicker.hour = calendar.get(Calendar.HOUR_OF_DAY)
        } else {
            binding.timePicker.currentMinute = calendar.get(Calendar.MINUTE)
            binding.timePicker.currentHour = calendar.get(Calendar.HOUR_OF_DAY)
        }
    }

    private fun setOnButtonSaveClickListener() {
        binding.buttonSetTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.YEAR, binding.datePicker.year)
            calendar.set(Calendar.MONTH, binding.datePicker.month)
            calendar.set(Calendar.DAY_OF_MONTH, binding.datePicker.dayOfMonth)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                calendar.set(Calendar.HOUR_OF_DAY, binding.timePicker.hour)
                calendar.set(Calendar.MINUTE, binding.timePicker.minute)
            } else {
                calendar.set(Calendar.HOUR_OF_DAY, binding.timePicker.currentHour)
                calendar.set(Calendar.MINUTE, binding.timePicker.currentMinute)
            }

            NavigationUtils.onTimeSelected(calendar.timeInMillis)
            this.dismiss()
        }
    }
}