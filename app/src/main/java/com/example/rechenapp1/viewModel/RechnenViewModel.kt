package com.example.rechenapp1.viewModel


import androidx.lifecycle.ViewModel
import com.example.rechenapp1.model.Rechnung

class RechnenViewModel : ViewModel() {
    private val rechnung = Rechnung()
    var aktuellesErgebnis = rechnung.gibErgebnis()
    var bisherherigesErgebnis = aktuellesErgebnis


    fun rechnen(eingabe : Int){
        bisherherigesErgebnis = rechnung.gibErgebnis()
        aktuellesErgebnis = rechnung.rechnen(eingabe)

    }

    fun zuruecksetzen(){
        rechnung.zurueckSetzen()
        aktuellesErgebnis = rechnung.gibErgebnis()
        bisherherigesErgebnis = aktuellesErgebnis
    }

}