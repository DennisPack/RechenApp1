package com.example.rechenapp1

data class Rechnung(private var aktuellesErgebnis : Int = 0){
    fun rechnen(bisherigesErgebnis : Int) : Int{
        aktuellesErgebnis += bisherigesErgebnis
        return aktuellesErgebnis
    }
    fun reset() {
        aktuellesErgebnis = 0
    }

    fun gibErgebnis() = aktuellesErgebnis
}