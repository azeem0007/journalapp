package com.example.journalapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EntriesAdapter(private val entries: List<JournalEntry>) :
    RecyclerView.Adapter<EntriesAdapter.EntryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_journal_entry, parent, false)
        return EntryViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val entry = entries[position]
        holder.memoryNameTextView.text = entry.memoryName
        holder.journalTextView.text = entry.journalText
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    class EntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val memoryNameTextView: TextView = itemView.findViewById(R.id.memoryNameTextView)
        val journalTextView: TextView = itemView.findViewById(R.id.journalTextView)
    }
}
