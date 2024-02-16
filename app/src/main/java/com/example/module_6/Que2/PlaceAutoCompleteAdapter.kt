package com.example.module_6.Que2

import android.content.Context
import android.util.Log
import android.widget.ArrayAdapter
import com.google.android.gms.common.api.ApiException
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse
import com.google.android.libraries.places.api.net.PlacesClient

class PlaceAutoCompleteAdapter(context: Context,
                               private val placesClient: PlacesClient
) : ArrayAdapter<AutocompletePrediction>(context, android.R.layout.simple_dropdown_item_1line) {

    private val TAG = "PlaceAutocompleteAdapter"

    // Fetch autocomplete predictions as the user types
    fun getPredictions(query: String) {
        val token = AutocompleteSessionToken.newInstance()

        val request = FindAutocompletePredictionsRequest.builder()
            .setSessionToken(token)
            .setQuery(query)
            .setTypeFilter(TypeFilter.ADDRESS) // You can customize the type filter as needed
            .build()

        placesClient.findAutocompletePredictions(request)
            .addOnSuccessListener { response: FindAutocompletePredictionsResponse ->
                clear()
                for (prediction in response.autocompletePredictions) {
                    add(prediction)
                }
                notifyDataSetChanged()
            }
            .addOnFailureListener { exception: Exception ->
                if (exception is ApiException) {
                    Log.e(TAG, "Place not found: " + exception.statusCode)
                }
            }
    }
}