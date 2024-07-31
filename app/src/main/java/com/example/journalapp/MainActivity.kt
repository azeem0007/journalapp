package com.example.journalapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var memoryNameEditText: EditText
    private lateinit var journalEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var viewButton: Button
    private val journalEntries = mutableListOf<JournalEntry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        memoryNameEditText = findViewById(R.id.memoryNameEditText)
        journalEditText = findViewById(R.id.journalEditText)
        saveButton = findViewById(R.id.saveButton)
        viewButton = findViewById(R.id.viewButton)

        saveButton.setOnClickListener {
            val memoryName = memoryNameEditText.text.toString()
            val journalText = journalEditText.text.toString()
            if (memoryName.isNotEmpty() && journalText.isNotEmpty()) {
                journalEntries.add(JournalEntry(memoryName, journalText))
                memoryNameEditText.text.clear()
                journalEditText.text.clear()
            }
        }

        viewButton.setOnClickListener {
            showViewEntriesFragment()
        }
    }

    private fun showViewEntriesFragment() {
        val fragment = ViewEntriesFragment.newInstance(journalEntries)
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .addToBackStack(null)
            .commit()
    }
}
