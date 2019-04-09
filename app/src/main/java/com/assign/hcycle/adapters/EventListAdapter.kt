package com.assign.hcycle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assign.hcycle.R
import kotlinx.android.synthetic.main.event_list_item.view.*

/**
 * Created by ivasil on 4/1/2019
 */

class EventListAdapter(val events: ArrayList<String>) : RecyclerView.Adapter<EventListAdapter.EventListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListViewHolder {
        return EventListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.event_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventListViewHolder, position: Int) {
        holder.eventName.text = events[position]
    }


    class EventListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val eventName: TextView = itemView.eventName
    }
}