package com.example.pddiary.models

import java.util.Date

class DiaryEntry(data: ArrayList<DairyModel>) {
    private var entry: ArrayList<DairyModel> = data
    private var updateLog: ArrayList<Date> = arrayListOf(Date())

    fun update(data: ArrayList<DairyModel>) {
        entry = data
        updateLog.add(Date())
    }

    override fun toString(): String {
        return "DiaryEntry(createdOn=${createdOn()}, lastUpdatedOn=${lastUpdatedOn()}, numUpdates=${numUpdates()}, ${updateLog})"
    }

    private fun createdOn() : Date {
        return updateLog[0]
    }

    private fun lastUpdatedOn() : Date {
        return updateLog.last()
    }

    private fun numUpdates() : Int {
        return updateLog.size
    }

    fun getEntry(): ArrayList<DairyModel> { return entry}
}