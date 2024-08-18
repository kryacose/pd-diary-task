package com.example.pddiary.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pddiary.R
import com.example.pddiary.models.DairyListItem
import com.example.pddiary.models.DairyModel
import com.google.android.material.textfield.TextInputLayout


class DairyAdapter(private val list: ArrayList<DairyModel>) : RecyclerView.Adapter<DairyAdapter.ItemViewHolder>() {

//    companion object {
//        val HEADER = 1
//        val ROW = 2
//        val BUTTON = 3
//    }

//    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val time: TextView = itemView.findViewById(R.id.time)
        val on: CheckBox = itemView.findViewById(R.id.on)
        val asleep: CheckBox = itemView.findViewById(R.id.asleep)
        val onWithTroublesome: CheckBox = itemView.findViewById(R.id.on_with_troublesome)
        val onWithoutTroublesome: CheckBox = itemView.findViewById(R.id.on_without_troublesome)
        val off: CheckBox = itemView.findViewById(R.id.off)
//        val measurementSlider: Slider = itemView.findViewById(R.id.measurement_slider)
        val measurementInputSeekBar: SeekBar = itemView.findViewById((R.id.measurement_input_seek_bar))
        val measurementInputLayout: TextInputLayout = itemView.findViewById(R.id.measurement_input_layout) // Added this line
    }

//    class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val button: Button = itemView.findViewById(R.id.dairy_save_button)
//    }

//    override fun getItemViewType(position: Int): Int {
//        return when (list[position]) {
//            is HeaderModel -> HEADER
//            is DairyModel -> ROW
//            is DairyButtonModel -> BUTTON
//            else -> throw IllegalArgumentException("unsupported type is sent to dairyAdapter")
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_dairy_row, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list[position]
        // Alternate row colors
        val backgroundColor = if (position % 2 == 0) Color.WHITE else Color.parseColor("#EAEAEA")
        holder.itemView.setBackgroundColor(backgroundColor)

        holder.asleep.setOnCheckedChangeListener(null)
        holder.on.setOnCheckedChangeListener(null)
        holder.onWithTroublesome.setOnCheckedChangeListener(null)
        holder.onWithoutTroublesome.setOnCheckedChangeListener(null)
        holder.off.setOnCheckedChangeListener(null)
//                mHolder.measurementInput.addTextChangedListener(null)




        holder.time.text = item.time
        holder.asleep.isChecked = item.asleep
        holder.on.isChecked = item.on
        holder.onWithTroublesome.isChecked = item.onWithTroublesome
        holder.onWithoutTroublesome.isChecked = item.onWithoutTroublesome
        holder.off.isChecked = item.off
        holder.measurementInputSeekBar.progress = item.measurement

        if (item.asleep) {
            holder.measurementInputSeekBar.progress = 0
            holder.measurementInputSeekBar.isEnabled = false
        } else {
            holder.measurementInputSeekBar.isEnabled = true
        }

        val checkboxListener = View.OnClickListener {
            item.asleep = holder.asleep.isChecked
            item.on = holder.on.isChecked
            item.onWithTroublesome = holder.onWithTroublesome.isChecked
            item.onWithoutTroublesome = holder.onWithoutTroublesome.isChecked
            item.off = holder.off.isChecked
            item.measurement = holder.measurementInputSeekBar.progress

            if (it == holder.asleep) {
                item.on = false
                item.onWithTroublesome = false
                item.onWithoutTroublesome = false
                item.off = false
                item.measurement = 0
                holder.measurementInputSeekBar.progress = 0
                holder.measurementInputSeekBar.isEnabled = false
            } else {
                holder.measurementInputSeekBar.isEnabled = true
                if (it == holder.on) {
                    item.asleep = false
                    item.onWithTroublesome = false
                    item.onWithoutTroublesome = false
                    item.off = false
                } else if (it == holder.onWithTroublesome) {
                    item.asleep = false
                    item.on = false
                    item.onWithoutTroublesome = false
                    item.off = false
                } else if (it == holder.onWithoutTroublesome) {
                    item.asleep = false
                    item.on = false
                    item.onWithTroublesome = false
                    item.off = false
                } else if (it == holder.off) {
                    item.asleep = false
                    item.on = false
                    item.onWithTroublesome = false
                    item.onWithoutTroublesome = false
                }
            }

            notifyItemChanged(position)
        }

        holder.asleep.setOnClickListener(checkboxListener)
        holder.on.setOnClickListener(checkboxListener)
        holder.onWithTroublesome.setOnClickListener(checkboxListener)
        holder.onWithoutTroublesome.setOnClickListener(checkboxListener)
        holder.off.setOnClickListener(checkboxListener)

    holder.measurementInputSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            item.measurement = progress
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {}

        override fun onStopTrackingTouch(seekBar: SeekBar) {}
    })



//            is DairyButtonModel -> {
//                val bHolder = holder as ButtonViewHolder
//                bHolder.button.setOnClickListener {
//                    val tempList = ArrayList<DairyModel>()
//                    for (tempItem in list) {
//                        if(tempItem is DairyModel)
//                            tempList.add(tempItem)
//                    }
//                    saveCallback(tempList)
//
//                }
//            }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getCurrentList(): List<DairyListItem> {
        return list
    }

//    private fun showAlertDialog(view: View, title: String, message: String) {
//        AlertDialog.Builder(view.context)
//            .setTitle(title)
//            .setMessage(message)
//            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
//            .show()
//    }


}