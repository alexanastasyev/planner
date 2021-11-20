package app.alexanastasyev.planner.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.databinding.DialogConfirmDeleteBinding
import app.alexanastasyev.planner.utils.NavigationUtils

class ConfirmDeleteDialog : DialogFragment() {
    private lateinit var binding: DialogConfirmDeleteBinding

    override fun getTheme() = R.style.RoundedCornersDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DialogConfirmDeleteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnYesClickListener()
        setOnCancelClickListener()
    }

    private fun setOnYesClickListener() {
        this.binding.buttonYes.setOnClickListener {
            NavigationUtils.onDeleteConfirm()
        }
    }

    private fun setOnCancelClickListener() {
        this.binding.buttonCancel.setOnClickListener {
            this.dismiss()
        }
    }
}