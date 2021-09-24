package app.alexanastasyev.planner.ui.screens.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.domain.Note
import java.text.SimpleDateFormat
import java.util.*

class NotesAdapter(
    private val notes: List<Note>,
    private val onClick: (position: Int) -> Unit = {}
) : RecyclerView.Adapter<NoteViewHolder>()  {

    companion object {
        private const val DATE_FORMAT = "d MMMM"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(itemView, onClick)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.binding.textViewNoteItemText.text = note.text
        if (note.date != null) {
            holder.binding.textViewNoteItemDate.text = SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(note.date)
        } else {
            holder.binding.textViewNoteItemDate.text = holder.binding.root.context.getString(R.string.no_date)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}