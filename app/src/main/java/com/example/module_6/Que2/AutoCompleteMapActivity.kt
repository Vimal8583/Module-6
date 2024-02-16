package com.example.module_6.Que2

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.module_6.R
import com.example.module_6.databinding.ActivityAutoCompleteMapBinding
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Status
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.PlaceTypes
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.net.*
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener

class AutoCompleteMapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityAutoCompleteMapBinding // Correct binding class
    private val TAG = "AutocompleteMapActivity"

    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutoCompleteMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Places.initialize(applicationContext, "AIzaSyDnPqrNtTtvOq04iKQe19-_ueZuP3zr8jc")
        // AutoCompleteMapActivity
        val autocompleteContainer = binding.autocompleteContainer // Use the binding object

// Dynamically add AutocompleteSupportFragment to the FrameLayout
        val autocompleteFragment = AutocompleteSupportFragment()
        autocompleteFragment.setPlaceFields(listOf(Place.Field.ID, Place.Field.NAME))

        supportFragmentManager.beginTransaction()
            .replace(com.example.module_6.R.id.autocomplete_container, autocompleteFragment)
            .commit()

        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                val selectedPlaceInfo = "Selected Place Info: ${place.name}, ${place.id}"
                findViewById<TextView>(R.id.selected_place_info).text = selectedPlaceInfo
                Log.i(TAG, "Place: ${place.name}, ${place.id}")
            }

            override fun onError(status: Status) {
                Log.i(TAG, "An error occurred: $status")
            }
        })

        // Initialize the MapView
        mapView = binding.mapView // Use the binding object
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        // Additional code related to Autocomplete Session and Predictions Request
        val token = AutocompleteSessionToken.newInstance()
        val bounds = RectangularBounds.newInstance(
            LatLng(-33.880490, 151.184363),
            LatLng(-33.858754, 151.229596)
        )
        val query = "" // You can get user input here dynamically
        val request = FindAutocompletePredictionsRequest.builder()
            .setLocationBias(bounds)
            .setOrigin(LatLng(-33.8749937, 151.2041382))
            .setCountries("AU", "NZ")
            .setTypesFilter(listOf(PlaceTypes.ADDRESS))
            .setSessionToken(token)
            .setQuery(query)
            .build()

        val placesClient: PlacesClient = Places.createClient(this)
        placesClient.findAutocompletePredictions(request)
            .addOnSuccessListener { response: FindAutocompletePredictionsResponse ->
                for (prediction in response.autocompletePredictions) {
                    Log.i(TAG, prediction.placeId)
                    Log.i(TAG, prediction.getPrimaryText(null).toString())
                }
            }.addOnFailureListener { exception: Exception? ->
                if (exception is ApiException) {
                    Log.e(TAG, "Place not found: ${exception.statusCode}")
                }
            }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        // Customize map settings
        googleMap.uiSettings.isZoomControlsEnabled = true
        googleMap.uiSettings.isMyLocationButtonEnabled = true

        // For simplicity, set a default location and add a marker
        val defaultLocation = LatLng(-33.8688, 151.2093) // Sydney, Australia
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 15f))

        // Add a marker to the default location
        googleMap.addMarker(MarkerOptions().position(defaultLocation).title("Default Location"))

        // You can add more markers, polygons, polylines, etc., as needed
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
