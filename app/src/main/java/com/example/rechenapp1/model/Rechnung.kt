package com.example.rechenapp1.model

data class Rechnung(private var aktuellesErgebnis : Int = 0){

    fun rechnen(eingabe : Int) : Int{
        aktuellesErgebnis += eingabe
        return aktuellesErgebnis
    }
    fun zurueckSetzen() {
        aktuellesErgebnis = 0
    }

    fun gibErgebnis() = aktuellesErgebnis
}