package com.example.pddiary.models

import android.util.Log
import java.time.LocalDate
import java.util.Date

class DiaryEntry(data: ArrayList<DairyModel>) {
    private var entry: ArrayList<DairyModel> = data
    private val createdOn: Date = Date()
    private var lastUpdatedOn: Date = Date()
    private var numUpdates: Int = 0

    fun update(data: ArrayList<DairyModel>) {
        entry = data
        lastUpdatedOn = Date()
        numUpdates++
    }

    override fun toString(): String {
        return "DiaryEntry(createdOn=$createdOn, lastUpdatedOn=$lastUpdatedOn, numUpdates=$numUpdates)"
    }

    fun getEntry(): ArrayList<DairyModel> { return entry}
}