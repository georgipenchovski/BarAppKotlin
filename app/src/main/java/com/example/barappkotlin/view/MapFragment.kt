package com.example.barappkotlin.view


import android.location.Location
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.example.barappkotlin.MapViewModel
import com.example.barappkotlin.R
import com.example.barappkotlin.model.BarModel
import com.example.barappkotlin.view.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_map.*

class MapFragment : BaseFragment(), OnMapReadyCallback {
    lateinit var googleMap: GoogleMap
    private var isUiInitiated = false
    private val userLocation: Location? = null
    private val bars: List<BarModel>? = null
    private lateinit var viewModel: MapViewModel

    override fun getLayoutRes(): Int {
        return R.layout.fragment_map
    }

    override fun onFragmentViewCreated(view: View?, savedInstanceState: Bundle?): View? {
        map_view.onCreate(savedInstanceState)
        map_view.onResume()
        map_view.getMapAsync(this)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onMapReady(map: GoogleMap?) {
        googleMap = map!!

        //These coordinates represent the latitude and longitude of the Googleplex.
        val latitude = 42.6679
        val longitude = 23.2917
        val zoomLevel = 15f

        val homeLatLng = LatLng(latitude, longitude)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng, zoomLevel))
        googleMap.addMarker(MarkerOptions().position(homeLatLng))
//            onUserLocationChanged(userLocation, bars)
    }

    override fun onUserLocationChanged(location: Location?, bars: List<BarModel?>?) {
    }

}

