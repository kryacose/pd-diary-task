package com.example.pddiary.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.pddiary.R
import com.example.pddiary.fragments.PrevDiaryFragment
import java.time.LocalDate
import java.util.Date

class PrevDiaryAdapter(private val dates: ArrayList<LocalDate>, private val navigateToDiary: (LocalDate)->Unit) :
    RecyclerView.Adapter<PrevDiaryAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.prev_diary_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dates.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val date = dates[position]
        holder.btn.text = date.toString()
        holder.btn.setOnClickListener { navigateToDiary(date) }
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val btn : Button = itemView.findViewById(R.id.prevDiaryItem)
    }

}