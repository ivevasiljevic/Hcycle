package com.assign.hcycle.views.fragments

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.opengl.Visibility
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.fragment.app.Fragment
import com.assign.hcycle.R
import com.assign.hcycle.viewmodels.TripViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.fragment_trip.*
import kotlinx.android.synthetic.main.fragment_trip.view.*

class TripFragment : Fragment(), OnMapReadyCallback {

    private lateinit var tripViewModel: TripViewModel
    lateinit var map: MapView
    private var isTripActive = false
    private var pauseOffset: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_trip, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapSetup(savedInstanceState)

        startStopTrip.setOnClickListener {

            startStopTrip()
        }

        hideMapSwitch.setOnCheckedChangeListener { _, isChecked ->

            hideShowMap(isChecked)
        }

    }

    private fun mapSetup(savedInstanceState: Bundle?) {

        map = tripMap
        map.onCreate(savedInstanceState)
        map.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {

        p0?.mapType = GoogleMap.MAP_TYPE_SATELLITE
    }

    private fun startStopTrip() {

        isTripActive = if(isTripActive) {

            tripTimer.stop()
            pauseOffset = SystemClock.elapsedRealtime() - tripTimer.base
            false
        }
        else {
            tripTimer.base = SystemClock.elapsedRealtime() - pauseOffset
            tripTimer.start()
            true
        }
    }

    private fun hideShowMap(isChecked: Boolean) {

        if(isChecked) {

            tripMap.animate().apply {

                translationY(-tripMap.height.toFloat())
                alpha(0.0f)
                setListener(object: AnimatorListenerAdapter() {

                    override fun onAnimationStart(animation: Animator?) {
                        super.onAnimationStart(animation)
                        tripMap.visibility = View.GONE
                    }
                })
            }
        }
        else {

            tripMap.visibility = View.VISIBLE
            tripMap.alpha = 0.0f

            tripMap.animate().apply {

                translationY(0.0f)
                alpha(1.0f)
                setListener(null)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        map.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onStart() {
        super.onStart()
        map.onStart()
    }

    override fun onStop() {
        super.onStop()
        map.onStop()
        }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }
}
