package com.example.rechenapp1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rechenapp1.R
import com.example.rechenapp1.databinding.ActivityMainBinding
import com.example.rechenapp1.viewModel.RechnenViewModel

class RechnenActivity : AppCompatActivity() {

    // ViewModel
    private lateinit var meinViewModel : RechnenViewModel
    // DataBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LOGS", "--> OnCreate aufgerufen")

        // DataBinding - Statt "setContentView(R.layout.activity_main)"
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // ViewModel von Java-Hilfsklasse zuweisen lassen - Hilfsklasse verlangt eine Activity (this) und ein ViewModel (RechnenViewModel)
        meinViewModel = ViewModelProvider(this).get(RechnenViewModel::class.java)

        // Buttons mit DataBinding statt FindViewById
        binding.buttonRechnen.setOnClickListener {
            meinViewModel.rechnen(binding.EingabeZahl.text.toString().toInt())
        }
        binding.buttonReset.setOnClickListener {
            meinViewModel.zuruecksetzen()
        }

        //   ALTE Methode aus Präsentation um die Texte in der Ansicht zu aktualisieren:
        //
        //   binding.buttonReset.setOnClickListener {
        //     meinViewModel.zuruecksetzen()
        //
        //    // UI aktualisieren
        //    //binding.feldAktuellesErgebnis.text = meinViewModel.aktuellesErgebnis.toString()
        //    //binding.feldBisherigesErgebnis.text = meinViewModel.bisherherigesErgebnis.toString()
        //    }
        //
        //    Hier haben wir die View-Felder immer manuell aktualisiert, wenn wir den Button gedrückt haben.
        //    Dies hatte jedoch den Nachteil, dass nach einer Bildschirmdrehung erst die Default-Werte (0) angezeigt wurden, bis der Button dann erneut gedrückt wurde.

        // NEUE Methode zum aktualisieren mit Observer und LiveData
        // Mit dem ersten Teil (bis zum {}) erstellen wir einen Observer, der unsere LiveData-Objekte überwacht.
        // Dieser muss einer Activity (einem Lifecycle-Owner) zugeordnet werden (this).
        // in der {} sagen wir dann, was passieren soll, wenn sich unser LiveData-Objekt ändert -> In unserem Fall die Aktualisierung des View-Feldes.
        // Dadurch werden die aktuellen Ergebnisse nun auch DIREKT nach der Drehung des Bildschirms angezeigt.
        meinViewModel.bisherigesLiveDataErgebnis.observe(this, Observer { binding.feldBisherigesErgebnis.text = it.toString() })
        meinViewModel.aktuellesLiveDataErgebnis.observe(this, Observer { binding.feldAktuellesErgebnis.text = it.toString() })
    }


    // Activity Zustände -> Um diese bei der Ausführung zu sehen, unter Logcat nach dem Tag "LOGS" filtern
    // Hat keine Relevanz für die Rechenapp
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