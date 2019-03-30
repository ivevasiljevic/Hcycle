package com.assign.hcycle.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.assign.hcycle.R
import com.assign.hcycle.viewmodels.TripViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.fragment_trip.*

class TripFragment : Fragment(), OnMapReadyCallback {

    private lateinit var tripViewModel: TripViewModel
    lateinit var map: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_trip, container, false)
        map = view.findViewById(R.id.tripMap)
        map.onCreate(savedInstanceState)
        map.getMapAsync(this)
        return view
    }

    override fun onMapReady(p0: GoogleMap?) {

        p0?.mapType = GoogleMap.MAP_TYPE_SATELLITE
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
