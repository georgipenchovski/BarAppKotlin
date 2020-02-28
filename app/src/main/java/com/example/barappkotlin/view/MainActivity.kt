package com.example.barappkotlin.view

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.barappkotlin.R
import com.example.barappkotlin.adapters.MyViewPagerAdapter
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var map: GoogleMap
    val MY_PERMISSIONS_REQUEST_LOCATION = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigationViews()
    }

    private fun setupNavigationViews() {
        val adapter =
            MyViewPagerAdapter(
                supportFragmentManager
            )
        adapter.addFragment(BarFragment(), "Bar")
        adapter.addFragment(MapFragment(), "Map")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }


    private val locationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            if (locationResult == null) {
                return
            }
            for (location in locationResult.locations) {
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getLastLocationIfAvailable()
    }

    override fun onPause() {
        super.onPause()
        LocationServices.getFusedLocationProviderClient(this)
            .removeLocationUpdates(locationCallback)
    }

    private fun getLastLocationIfAvailable(): Location? {
        val locationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (locationManager == null || !locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            showAlertMessageNoGps()
        } else if (!isLocationPermissionGranted()) {
            requestLocationPermission()
        } else if (!isGooglePlayServicesAvailable()) {
            finish()
        } else {
            setupPeriodicLocationUpdates()
            return getLastKnownLocationLocation(locationManager)
        }
        return null
    }

    private fun setupPeriodicLocationUpdates() {
        val locationRequest = LocationRequest()
        locationRequest.interval = 60000
        locationRequest.fastestInterval = 15000
        locationRequest.priority = LocationRequest.PRIORITY_NO_POWER
        LocationServices.getFusedLocationProviderClient(this)
            .requestLocationUpdates(
                locationRequest, locationCallback, Looper.getMainLooper()
            )
    }

    @SuppressLint("MissingPermission")
    fun getLastKnownLocationLocation(locationManager: LocationManager): Location? {
        val location: Location
        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        return location
    }

    private fun showAlertMessageNoGps() {
        val builder =
            AlertDialog.Builder(this)
        builder.setMessage(getString(R.string.error_turn_on_gps))
            .setCancelable(false)
            .setPositiveButton(
                getString(R.string.yes)
            ) { dialog, id -> startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)) }
            .setNegativeButton(
                getString(R.string.no)
            ) { dialog, id -> dialog.cancel() }
        val alert = builder.create()
        alert.show()
    }

    private fun isGooglePlayServicesAvailable(): Boolean {
        val googleAPI = GoogleApiAvailability.getInstance()
        val result = googleAPI.isGooglePlayServicesAvailable(this)
        if (result != ConnectionResult.SUCCESS) {
            if (googleAPI.isUserResolvableError(result)) {
                googleAPI.getErrorDialog(
                    this, result,
                    0
                ).show()
            }
            return false
        }
        return true
    }

    fun isLocationPermissionGranted(): Boolean {
        return (ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
                == PackageManager.PERMISSION_GRANTED)
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            MY_PERMISSIONS_REQUEST_LOCATION
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        if (requestCode == MY_PERMISSIONS_REQUEST_LOCATION) {
            if (grantResults.size > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                    == PackageManager.PERMISSION_GRANTED
                ) {
                    getLastLocationIfAvailable()
                }
            }
        }
    }
}