package app.alexanastasyev.planner.ui.screens.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import app.alexanastasyev.planner.R
import app.alexanastasyev.planner.domain.Note
import app.alexanastasyev.planner.domain.Priority
import java.text.SimpleDateFormat
import java.util.*

class NotesAdapter(
    private val notes: List<Note>,
    private val onClick: (position: Int) -> Unit = {}
) : RecyclerView.Adapter<NoteViewHolder>()  {

    companion object {
        private const val DATE_FORMAT = "dd.MM.yyyy"
        private const val TIME_FORMAT = "hh:mm"
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
            holder.binding.textViewNoteItemTime.text = SimpleDateFormat(TIME_FORMAT, Locale.getDefault()).format(note.date)
        } else {
            holder.binding.layoutDateTime.visibility = View.GONE
        }
        holder.binding.layoutNote.setBackgroundColor(when (note.priority) {
            Priority.LOW -> ContextCompat.getColor(holder.binding.root.context, R.color.grey_light)
            Priority.MEDIUM -> ContextCompat.getColor(holder.binding.root.context, R.color.blue)
            Priority.HIGH -> ContextCompat.getColor(holder.binding.root.context, R.color.red)
        })
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}