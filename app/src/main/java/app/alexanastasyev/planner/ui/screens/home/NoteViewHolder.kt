package app.alexanastasyev.planner.ui.screens.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.alexanastasyev.planner.databinding.ItemNoteBinding

class NoteViewHolder(
    itemView: View,
    onClick: (position: Int) -> Unit = {}
) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemNoteBinding.bind(itemView)
    init {
        binding.root.setOnClickListener { onClick(adapterPosition) }
    }
}