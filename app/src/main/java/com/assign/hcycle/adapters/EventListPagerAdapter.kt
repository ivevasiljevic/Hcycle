package com.assign.hcycle.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.assign.hcycle.views.fragments.EventListFragment

/**
 * Created by ivasil on 4/1/2019
 */

class EventListPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {

        val fragment = EventListFragment()

        fragment.arguments = Bundle().apply {

            putInt(EventListFragment.EXTRA_EVENT_INDEX, position)
        }

        return fragment
    }

    override fun getCount(): Int {
        return 2
    }
}