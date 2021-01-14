package com.example.rechenapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class RechnenActivity : AppCompatActivity() {

    val rechnung = Rechnung()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LOGS", "--> OnCreate aufgerufen")

        setContentView(R.layout.activity_main)

        // Ergebnisfelder
        val aktuellesErgebnisFeld: TextView = findViewById(R.id.feld_aktuellesErgebnis)
        val vorherigesErgebnisFeld: TextView = findViewById(R.id.feld_bisherigesErgebnis)

        // Buttons
        val buttonRechnen: Button = findViewById(R.id.button_rechnen)
        buttonRechnen.setOnClickListener { rechnen(aktuellesErgebnisFeld, vorherigesErgebnisFeld) }
        val buttonReset: Button = findViewById(R.id.button_reset)
        buttonReset.setOnClickListener { zuruecksetzen(aktuellesErgebnisFeld, vorherigesErgebnisFeld) }
    }



    fun rechnen(aktuellesErgebnisFeld : TextView, vorherigesErgebnisFeld : TextView){
        // Vorheriges Ergebnis in UI setzen
        vorherigesErgebnisFeld.text = aktuellesErgebnisFeld.text

        // UserEingabe holen
        val eingabeFeld = findViewById<TextView>(R.id.Eingabe_Zahl)
        val eingabe = eingabeFeld.text.toString().toInt()
        // Rechnung und Ergebnis an UI geben
        aktuellesErgebnisFeld.text = rechnung.rechnen(eingabe).toString()
    }


    fun zuruecksetzen(ergebnisFeld: TextView, bisherigesErgebnis: TextView){
        bisherigesErgebnis.text = 0.toString()
        ergebnisFeld.text = 0.toString()
        rechnung.reset()
    }





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