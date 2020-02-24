package com.example.barappkotlin.view


import android.location.Location
import android.os.Bundle
import android.view.View
import com.example.barappkotlin.R
import com.example.barappkotlin.model.BarModel
import com.example.barappkotlin.view.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.fragment_map.*

class MapFragment : BaseFragment(), OnMapReadyCallback {
    lateinit var googleMap: GoogleMap
    private var isUiInitiated = false
    private val userLocation: Location? = null
    private val bars: List<BarModel>? = null

    override fun getLayoutRes(): Int {
        return R.layout.fragment_map
    }

    override fun onFragmentViewCreated(view: View?, savedInstanceState: Bundle?): View? {
        map_view.onCreate(savedInstanceState)
        map_view.onResume()
        map_view.getMapAsync(this)
        return view
    }

    override fun onUserLocationChanged(location: Location?, bars: List<BarModel?>?) {
    }

    override fun onMapReady(map: GoogleMap?) {
        map?.let {
            googleMap = it
            googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            googleMap.isMyLocationEnabled = true
            googleMap.moveCamera(CameraUpdateFactory.zoomTo(15f))
            isUiInitiated = true
//            onUserLocationChanged(userLocation, bars)
        }
    }
}
