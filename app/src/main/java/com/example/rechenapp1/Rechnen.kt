package com.example.rechenapp1

data class Rechnung(private var ergebnis : Int = 0){
    fun rechnen(zahl : Int) : Int{
        ergebnis += zahl
        return ergebnis
    }
    fun reset() {
        ergebnis = 0
    }

    fun gibErgebnis() = ergebnis
}