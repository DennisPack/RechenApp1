package com.example.rechenapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val rechnung = Rechnung()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LOGS", "--> OnCreate aufgerufen")

        setContentView(R.layout.activity_main)

        val aktuellesErgebnisFeld: TextView = findViewById(R.id.feld_aktuellesErgebnis)
        val bisherigesErgebnisFeld: TextView = findViewById(R.id.feld_bisherigesErgebnis)


        val button_rechnen : Button = findViewById(R.id.button_rechnen)
        button_rechnen.setOnClickListener { rechnenAktion(aktuellesErgebnisFeld, bisherigesErgebnisFeld) }


        val button_reset : Button = findViewById(R.id.button_reset)
        button_reset.setOnClickListener { resetAktion(aktuellesErgebnisFeld, bisherigesErgebnisFeld) }
    }



    fun rechnenAktion(ergebnisFeld : TextView, bisherigesErgebnis : TextView){
        bisherigesErgebnis.text = ergebnisFeld.text

        val eingabeZahlFeld = findViewById<TextView>(R.id.Eingabe_Zahl)
        val zahl = eingabeZahlFeld.text.toString().toInt()
        ergebnisFeld.text = rechnung.rechnen(zahl).toString()
    }


    fun resetAktion(ergebnisFeld: TextView, bisherigesErgebnis: TextView){
        //bisherigesErgebnis.text = 0.toString()
        //ergebnisFeld.text = 0.toString()
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