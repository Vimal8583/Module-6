package com.example.module_6.Que3


import android.location.Geocoder
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.module_6.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException

class DisplayMarkerActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_marker)

        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        // Set default location to a city or a location of your choice
        val defaultLocation = LatLng(37.7749, -122.4194)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 10f))

        // Handle user input and add marker
        val addressEditText = findViewById<EditText>(R.id.addressEditText)
        findViewById<Button>(R.id.showOnMapButton).setOnClickListener {
            val address = addressEditText.text.toString()
            showMarkerOnMap(address)
        }
    }

    private fun showMarkerOnMap(address: String) {
        // Geocode the address to get its coordinates
        val geocoder = Geocoder(this)

        try {
            val addresses = geocoder.getFromLocationName(address, 1)
            if (addresses?.isNotEmpty()!!) {
                val location = LatLng(addresses[0].latitude, addresses[0].longitude)

                // Add a marker to the map
                map.clear() // Clear existing markers
                map.addMarker(MarkerOptions().position(location).title(address))
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
            } else {
                // Handle the case where no coordinates are found for the given address
                showToast("No coordinates found for the address")
            }
        } catch (e: IOException) {
            // Handle geocoding errors
            e.printStackTrace()
            showToast("Error during geocoding. Please try again.")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}
