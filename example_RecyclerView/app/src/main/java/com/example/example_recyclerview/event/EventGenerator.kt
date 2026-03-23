package com.example.example_recyclerview.event

import com.example.example_recyclerview.R

object EventGenerator {
    private val imageIdList: List<Int> = listOf(
        R.drawable.calendar_icon,
        R.drawable.lunch_icon,
        R.drawable.work_icon,
        R.drawable.meeting_icon
    )

    fun generateEvents(count: Int): List<Event> =
        (0..count).map { index ->
            Event(
                imageResId = imageIdList.random(),
                name = "Событие $index",
                time = "${(12..23).random()}:${(10..59).random()}"
            )
        }
}