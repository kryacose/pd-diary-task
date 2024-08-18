package com.example.pddiary.models

import java.time.LocalDate


class DiaryData {
    private val dateToEntry : HashMap<LocalDate, DiaryEntry> = HashMap()

    fun addOrUpdateEntry(date : LocalDate, entry : ArrayList<DairyModel>) {
        if(dateToEntry.contains(date))
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


}