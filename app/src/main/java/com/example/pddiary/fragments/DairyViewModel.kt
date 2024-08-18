package com.example.pddiary.fragments

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.pddiary.models.DairyButtonModel
import com.example.pddiary.models.DairyListItem
import com.example.pddiary.models.DairyModel
import com.example.pddiary.models.HeaderModel
import java.util.Date

class DairyViewModel : ViewModel() {
    private val date = Date()
    private val list = arrayListOf(
        DairyModel("12AM-12:30AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("12:30AM-1AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("1AM-1:30AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("1:30AM-2AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("2AM-2:30AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("2:30AM-3AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("3AM-3:30AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("3:30AM-4AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("4AM-4:30AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("4:30AM-5AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("5AM-5:30AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("5:30AM-6AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("6AM-6:30AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("6:30AM-7AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("7AM-7:30AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("7:30AM-8AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("8AM-8:30AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("8:30AM-9AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("9AM-9:30AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("9:30AM-10AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("10AM-10:30AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("10:30AM-11AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("11AM-11:30AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("11:30AM-12PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("12PM-12:30PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("12:30PM-1PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("1PM-1:30PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("1:30PM-2PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("2PM-2:30PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("2:30PM-3PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("3PM-3:30PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("3:30PM-4PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("4PM-4:30PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("4:30PM-5PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("5PM-5:30PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("5:30PM-6PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("6PM-6:30PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("6:30PM-7PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("7PM-7:30PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("7:30PM-8PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("8PM-8:30PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("8:30PM-9PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("9PM-9:30PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("9:30PM-10PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("10PM-10:30PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("10:30PM-11PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("11PM-11:30PM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
        DairyModel("11:30PM-12AM", asleep = false, on = false, onWithTroublesome = false, onWithoutTroublesome = false, off = false, measurement = 0),
    )

    fun getDairyList(): ArrayList<DairyModel> {
        return list
    }

//    fun saveDairyList(dairyList: List<DairyListItem>) {
//        list.clear()
//        Log.v("viewModel", "listReceived $dairyList")
//        list.addAll(dairyList)
//        Log.v("fragmentResumed", "listSaved" + list.size.toString() )
//    }


}