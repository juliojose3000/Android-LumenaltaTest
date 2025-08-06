package com.loaizasoftware.lumenaltatest.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.loaizasoftware.lumenaltatest.R
import com.loaizasoftware.lumenaltatest.presentation.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateToWeatherFragment(9.0, 9.0)
    }

    private fun navigateToWeatherFragment(lat: Double, lon: Double) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        val bundle = Bundle()
        bundle.putDouble("lat", lat)
        bundle.putDouble("lon", lon)

        val fragment = MainFragment()
        fragment.setArguments(bundle)

        transaction.replace(R.id.root, fragment) // Replace existing fragment (if any)
        transaction.addToBackStack(null) // Optional: allows user to go back
        transaction.commit()
    }

}