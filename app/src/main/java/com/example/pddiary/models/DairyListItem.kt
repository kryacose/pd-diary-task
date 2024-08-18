package com.example.pddiary.models


interface DairyListItem {
    val listItemType: Int
    companion object {
        const val ROW = 2
    }
}