package com.example.pddiary.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pddiary.MainActivity
import com.example.pddiary.R
import com.example.pddiary.adapter.DairyAdapter
import com.example.pddiary.adapter.PrevDiaryAdapter
import com.example.pddiary.databinding.HomeFragmentBinding
import com.example.pddiary.databinding.PrevDiaryFragmentBinding
import java.time.LocalDate
import java.util.Date


class PrevDiaryFragment : Fragment() {

    private lateinit var binding: PrevDiaryFragmentBinding
    private lateinit var dates : ArrayList<LocalDate>
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        dates = (activity as MainActivity).diaryData.getDates()
        dates.sort()
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = PrevDiaryFragmentBinding.inflate(inflater, container, false)
        recyclerView = binding.root.findViewById(R.id.prev_diary_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = PrevDiaryAdapter(dates, (activity as MainActivity)::navigateToDiary)
        binding.prevDiaryRecycler.adapter = adapter
    }

    companion object {
        fun newInstance() =
            PrevDiaryFragment().apply {}
    }
}