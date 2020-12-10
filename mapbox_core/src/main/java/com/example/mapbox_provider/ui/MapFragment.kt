package com.example.mapbox_provider.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mapbox_provider.R
import com.mapbox.geojson.Feature
import com.mapbox.geojson.FeatureCollection
import com.mapbox.geojson.Point
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.style.layers.PropertyFactory.*
import com.mapbox.mapboxsdk.style.layers.SymbolLayer
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import kotlinx.android.synthetic.main.fragment_map.*

class MapFragment : Fragment() {

    private val SOURCE_ID = "SOURCE_ID"
    private val ICON_ID = "ICON_ID"
    private val LAYER_ID = "LAYER_ID"

    private var mapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView = map_view
        mapView?.onCreate(savedInstanceState)

        val symbolLayerIconFeatureList: MutableList<Feature> = ArrayList()
        symbolLayerIconFeatureList.add(
            Feature.fromGeometry(
                Point.fromLngLat(-57.225365, -33.213144)
            )
        )
        symbolLayerIconFeatureList.add(
            Feature.fromGeometry(
                Point.fromLngLat(-54.14164, -33.981818)
            )
        )
        symbolLayerIconFeatureList.add(
            Feature.fromGeometry(
                Point.fromLngLat(-56.990533, -30.583266)
            )
        )
        mapView?.getMapAsync { mapboxMap ->

            mapboxMap.setStyle(Style.MAPBOX_STREETS) {
// Map is set up and the style has loaded. Now you can add data or make other map adjustments

                // Add the SymbolLayer icon image to the map style
                it.addImage(
                    ICON_ID, BitmapFactory.decodeResource(
                        this.getResources(),
                        R.drawable.mapbox_marker_icon_default
                    )
                )
// Adding a GeoJson source for the SymbolLayer icons.
                it.addSource(
                    GeoJsonSource(
                        SOURCE_ID,
                        FeatureCollection.fromFeatures(symbolLayerIconFeatureList)
                    )
                )
// Adding the actual SymbolLayer to the map style. An offset is added that the bottom of the red
// marker icon gets fixed to the coordinate, rather than the middle of the icon being fixed to
// the coordinate point. This is offset is not always needed and is dependent on the image
// that you use for the SymbolLayer icon.
                it.addLayer(
                    SymbolLayer(LAYER_ID, SOURCE_ID)
                        .withProperties(
                            iconImage(ICON_ID),
                            iconAllowOverlap(true),
                            iconIgnorePlacement(true)
                        )
                )

            }
        }
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mapView?.onDestroy()
    }
}