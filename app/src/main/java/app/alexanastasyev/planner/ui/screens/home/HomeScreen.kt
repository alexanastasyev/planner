package app.alexanastasyev.planner.ui.screens.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.alexanastasyev.planner.MainActivity
import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.databinding.ScreenHomeBinding
import java.text.SimpleDateFormat
import java.util.*

class HomeScreen : Fragment(), HomeView {

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

    override fun setTitle(title: String) {
        (activity as MainActivity).setActionBarTitle(title)
    }

    override fun provideContext(): Context {
        return requireContext()
    }
}