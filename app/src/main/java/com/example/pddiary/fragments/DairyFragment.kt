package com.example.pddiary.fragments

import android.icu.text.DateFormat
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pddiary.MainActivity
import com.example.pddiary.R
import com.example.pddiary.adapter.DairyAdapter
import com.example.pddiary.databinding.DairyFragmentBinding
import com.example.pddiary.models.DairyModel
import com.example.pddiary.models.DiaryEntry
import java.time.LocalDate
import java.util.Date

class DairyFragment() : Fragment() {

    private lateinit var dairyBinding: DairyFragmentBinding
    private val binding: DairyFragmentBinding get() = dairyBinding

    private lateinit var viewModel: DairyViewModel
    private lateinit var diaryEntry: ArrayList<DairyModel>
    private lateinit var dateBtn: Button
    private lateinit var calendar: CalendarView
    private lateinit var selectedDate: LocalDate
    private lateinit var saveBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        dairyBinding = DairyFragmentBinding.inflate(inflater, container, false)
        dateBtn = dairyBinding.root.findViewById(R.id.date_btn)
        calendar = dairyBinding.root.findViewById(R.id.calendar)
        saveBtn = dairyBinding.root.findViewById(R.id.saveBtn)

        saveBtn.setOnClickListener { saveBtnCallback() }

        dateBtn.text = selectedDate.toString()
        dateBtn.setOnClickListener { dateBtnCallback() }
        calendar.setOnDateChangeListener { _, year, month, day ->  calendarCallback(year, month, day)}
        calendar.visibility = View.INVISIBLE


        return dairyBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedDate = LocalDate.parse(arguments?.getString("initDate"))
//        viewModel = ViewModelProvider(requireActivity())[DairyViewModel::class.java]
        fillDiaryEntry()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        binding.dairyRecyclerview.layoutManager = LinearLayoutManager(context)
        val adapter = DairyAdapter(diaryEntry)
        binding.dairyRecyclerview.adapter = adapter
    }

    override fun onPause() {
        val adapter = binding.dairyRecyclerview.adapter as DairyAdapter
        val listToSave = adapter.getCurrentList()
        super.onPause()
    }

    private fun saveBtnCallback() {
        (activity as MainActivity).diaryData.addOrUpdateEntry(selectedDate, diaryEntry)
        val savedEntry: DiaryEntry = (activity as MainActivity).diaryData.getEntry(selectedDate)
        Log.v("Diary Log", "Date: $selectedDate, $savedEntry")

    }

    private fun dateBtnCallback() {
        if(calendar.isVisible)
            calendar.visibility = View.INVISIBLE
        else calendar.visibility = View.VISIBLE
    }

    private fun calendarCallback(year: Int, month: Int, day: Int) {
        selectedDate = LocalDate.of(year, month+1, day)
        dateBtn.text = selectedDate.toString()
        calendar.visibility = View.INVISIBLE

        fillDiaryEntry()
        reloadRecyclerView()


    }

    private fun fillDiaryEntry() {
        viewModel = DairyViewModel()
        diaryEntry = viewModel.getDairyList()
        val diaryData = (activity as MainActivity).diaryData
        if(diaryData.containsDate(selectedDate))
            diaryEntry = diaryData.getEntry(selectedDate).getEntry()
    }

    private fun reloadRecyclerView() {
        binding.dairyRecyclerview.adapter = DairyAdapter(diaryEntry)

    }

}