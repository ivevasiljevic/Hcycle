package com.assign.hcycle.views.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.assign.hcycle.R
import com.assign.hcycle.adapters.EventListAdapter
import com.assign.hcycle.utils.DataProvider
import kotlinx.android.synthetic.main.event_list.view.*

class EventListFragment : Fragment() {

    companion object {

        const val EXTRA_EVENT_INDEX = "EVENT_INDEX"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.event_list, container, false)

        arguments?.takeIf {
            it.containsKey(EXTRA_EVENT_INDEX)
        }?.apply {

            setRecyclerViewAdapter(view, view.context)
        }

        return view
    }

    private fun setRecyclerViewAdapter(view: View, context: Context) {

        with(view.eventRecyclerView) {

            adapter = EventListAdapter(DataProvider.list)
            layoutManager = LinearLayoutManager(context)
        }
    }
}
