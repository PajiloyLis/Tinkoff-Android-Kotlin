package com.example.example_recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example_recyclerview.adapter.EventAdapter
import com.example.example_recyclerview.event.EventGenerator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eventRecycler: RecyclerView = findViewById(R.id.eventsRecycler)
        val eventsAdapter = EventAdapter()

        eventRecycler.adapter=eventsAdapter
        eventRecycler.layoutManager = LinearLayoutManager(this)

        eventsAdapter.data= EventGenerator.generateEvents(15)

    }
}