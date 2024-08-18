package com.example.pddiary.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.pddiary.MainActivity
import com.example.pddiary.R
import com.example.pddiary.databinding.HomeFragmentBinding
import java.time.LocalDate

class HomeFragment : Fragment() {

    private lateinit var homeBinding: HomeFragmentBinding
    private val binding get() = homeBinding

    private lateinit var newDiaryBtn : CardView
    private lateinit var updateDiaryBtn : CardView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = HomeFragmentBinding.inflate(inflater, container, false)
        newDiaryBtn = homeBinding.root.findViewById(R.id.new_diary)
        updateDiaryBtn = homeBinding.root.findViewById(R.id.update_diary)

        newDiaryBtn.setOnClickListener(){

            (activity as MainActivity).navigateToDiary(LocalDate.now())
        }

        updateDiaryBtn.setOnClickListener(){
            (activity as MainActivity).navigateToPrevDiary()
        }

        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}