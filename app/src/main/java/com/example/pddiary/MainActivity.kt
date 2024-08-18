package com.example.pddiary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.pddiary.databinding.MainActivityBinding
import com.example.pddiary.models.DiaryData
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var navController: NavController
    lateinit var diaryData: DiaryData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        diaryData = DiaryData()
        val view = binding.root
        setContentView(view)

        navController = findNavController(R.id.fragment_container)

        setSelectedState(home = true)

        binding.home.setOnClickListener {
            navigateToHome()
        }

        binding.dairy.setOnClickListener {
            navigateToDiary(LocalDate.now())
        }

        binding.profile.setOnClickListener {
            navigateToProfile()
        }
    }

    private fun navigateToProfile() {
        navController.navigate(R.id.action_global_profileFragment)
        setSelectedState(profile = true)
    }

    fun navigateToDiary(initDate : LocalDate) {
        val bundle = Bundle()
        bundle.putString("initDate", initDate.toString())
        navController.navigate(R.id.action_global_dairyFragment, bundle)
        setSelectedState(dairy = true)
    }

    fun navigateToPrevDiary() {
        navController.navigate(R.id.action_global_prevDiaryFragment)
        setSelectedState(dairy = true)
    }

    private fun navigateToHome() {
        navController.navigate(R.id.action_global_homeFragment)
        setSelectedState(home = true)
    }

    private fun setSelectedState(home: Boolean = false, dairy: Boolean = false, profile: Boolean = false) {
        binding.home.isSelected = home
        binding.dairy.isSelected = dairy
        binding.profile.isSelected = profile
    }
}