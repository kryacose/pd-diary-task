package com.example.pddiary.models

import androidx.loader.content.Loader
import java.time.LocalDate
import java.util.Date


class DiaryData {
    private val dateToEntry : HashMap<LocalDate, DiaryEntry> = HashMap<LocalDate, DiaryEntry>()

    fun addOrUpdateEntry(date : LocalDate, entry : ArrayList<DairyModel>) {
        if(containsDate(date))
            dateToEntry[date]?.update(entry)
        else
            dateToEntry[date] = DiaryEntry(entry)
    }

    fun containsDate(date : LocalDate) : Boolean {
        return dateToEntry.contains(date)
    }

    fun getEntry(date : LocalDate) : DiaryEntry {
        return dateToEntry.getOrDefault(date, DiaryEntry(ArrayList<DairyModel>()))
    }

    fun getDates():ArrayList<LocalDate> {
        return ArrayList(dateToEntry.keys)
    }

    fun numEntries():Int {
        return dateToEntry.size
    }

}