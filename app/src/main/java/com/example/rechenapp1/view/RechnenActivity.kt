package com.example.rechenapp1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.rechenapp1.R
import com.example.rechenapp1.databinding.ActivityMainBinding
import com.example.rechenapp1.viewModel.RechnenViewModel

class RechnenActivity : AppCompatActivity() {

    //ViewModel
    private lateinit var meinViewModel : RechnenViewModel
    //DataBinding
    private lateinit var binding: ActivityMainBinding
    // dad

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LOGS", "--> OnCreate aufgerufen")

        // DataBinding - Statt "setContentView(R.layout.activity_main)"
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // ViewModel von Hilfsklasse zuweisen lassen
        meinViewModel = ViewModelProvider(this).get(RechnenViewModel::class.java)

        // Buttons
        binding.buttonRechnen.setOnClickListener {
            meinViewModel.rechnen(binding.EingabeZahl.text.toString().toInt())
            // UI aktualisieren
            binding.feldAktuellesErgebnis.text = meinViewModel.aktuellesErgebnis.toString()
            binding.feldBisherigesErgebnis.text = meinViewModel.bisherherigesErgebnis.toString()
        }
        binding.buttonReset.setOnClickListener {
            meinViewModel.zuruecksetzen()
            // UI aktualisieren
            binding.feldAktuellesErgebnis.text = meinViewModel.aktuellesErgebnis.toString()
            binding.feldBisherigesErgebnis.text = meinViewModel.bisherherigesErgebnis.toString()
        }
    }

    // Activity Status
    override fun onStart() {
        super.onStart()
        Log.i("LOGS", "--> onStart aufgerufen")
    }
    override fun onResume() {
        super.onResume()
        Log.i("LOGS", "--> onResume aufgerufen")
    }
    override fun onPause() {
        super.onPause()
        Log.i("LOGS", "--> onPause aufgerufen")
    }
    override fun onStop() {
        super.onStop()
        Log.i("LOGS", "--> onStop aufgerufen")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i("LOGS", "--> onRestart aufgerufen")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("LOGS", "--> onDestroy aufgerufen")
    }
}