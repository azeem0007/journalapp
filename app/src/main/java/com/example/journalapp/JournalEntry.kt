package com.example.journalapp

import android.os.Parcel
import android.os.Parcelable

data class JournalEntry(val memoryName: String, val journalText: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(memoryName)
        parcel.writeString(journalText)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<JournalEntry> {
        override fun createFromParcel(parcel: Parcel): JournalEntry {
            return JournalEntry(parcel)
        }

        override fun newArray(size: Int): Array<JournalEntry?> {
            return arrayOfNulls(size)
        }
    }
}
