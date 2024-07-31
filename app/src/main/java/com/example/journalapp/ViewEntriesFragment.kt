package com.example.journalapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewEntriesFragment : Fragment() {

    companion object {
        private const val ARG_ENTRIES = "entries"

        fun newInstance(entries: List<JournalEntry>): ViewEntriesFragment {
            val fragment = ViewEntriesFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_ENTRIES, ArrayList(entries))
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var entriesRecyclerView: RecyclerView
    private lateinit var entriesAdapter: EntriesAdapter
    private var entries: List<JournalEntry> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        entries = arguments?.getParcelableArrayList(ARG_ENTRIES) ?: emptyList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_entries, container, false)
        entriesRecyclerView = view.findViewById(R.id.entriesRecyclerView)
        entriesRecyclerView.layoutManager = LinearLayoutManager(context)
        entriesAdapter = EntriesAdapter(entries)
        entriesRecyclerView.adapter = entriesAdapter

        // Add spacing between items
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.item_spacing)
        entriesRecyclerView.addItemDecoration(VerticalSpaceItemDecoration(spacingInPixels))

        return view
    }
}
