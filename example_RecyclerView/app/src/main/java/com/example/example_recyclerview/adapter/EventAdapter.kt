package com.example.example_recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.example_recyclerview.R
import com.example.example_recyclerview.event.Event

class EventAdapter: RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    var data: List<Event> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var eventImage : ImageView = itemView.findViewById(R.id.eventImage)
        val eventName : TextView = itemView.findViewById(R.id.eventName)
        val eventTime: TextView = itemView.findViewById(R.id.eventTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventViewHolder(itemView)
    }

    override fun getItemCount(): Int =data.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        data[position].let {
            holder.eventImage.setImageResource(it.imageResId)
            holder.eventName.text = it.name
            holder.eventTime.text = it.time
        }
    }
}