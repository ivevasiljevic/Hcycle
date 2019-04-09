package com.assign.hcycle.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import com.assign.hcycle.R
import com.assign.hcycle.adapters.EventListPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.event_list.view.*
import kotlinx.android.synthetic.main.fragment_events.view.*

class EventsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_events, container, false)

        setPagerAdapter(view)
        onTabLayoutItemSelected(view)
        onViewPagerChangeListener(view)

        return view
    }

    private fun setPagerAdapter(view: View) {
        with(view.eventsViewPager){
            adapter = EventListPagerAdapter(fragmentManager!!)
        }
    }

    private fun onTabLayoutItemSelected(view: View) {
        view.tabLayout.addOnTabSelectedListener( object : TabLayout.OnTabSelectedListener {

            override fun onTabReselected(p0: TabLayout.Tab?) {
                //do nothing
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                //do nothing
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                view.eventsViewPager.currentItem = p0?.position ?: 0

                if(p0?.position == 1) {
                    view.floatingButton.hide()
                }
            }
        })
    }

    private fun onViewPagerChangeListener(view: View) {
        view.eventsViewPager.addOnPageChangeListener( object: ViewPager.SimpleOnPageChangeListener() {

            override fun onPageSelected(position: Int) {
                view.tabLayout.getTabAt(position)?.select()

                if(position == 2) {
                    view.floatingButton.hide()
                }
            }
        })
    }
}
