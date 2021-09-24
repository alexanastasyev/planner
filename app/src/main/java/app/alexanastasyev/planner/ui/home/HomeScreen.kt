package app.alexanastasyev.planner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.alexanastasyev.planner.databinding.ScreenHomeBinding
import java.text.SimpleDateFormat
import java.util.*

class HomeScreen : Fragment(), HomeView {
    companion object {
        private const val DATE_FORMAT = "d MMMM"
        private const val DAY_OF_WEEK_FORMAT = "EEEE"
    }

    private lateinit var binding: ScreenHomeBinding
    private val presenter = HomePresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ScreenHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.init()
    }

    override fun displayDate(dateTime: Date) {
        val dateAsString = SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(dateTime)
        val dayOfWeekAsString = SimpleDateFormat(DAY_OF_WEEK_FORMAT, Locale.getDefault()).format(dateTime)

        binding.textView.text = "HOME SCREEN\nDate: $dateAsString\nDay: $dayOfWeekAsString"
    }

}