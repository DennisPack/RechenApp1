package com.example.rechenapp1.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rechenapp1.model.Rechnung

class RechnenViewModel : ViewModel() {

    private val rechnung = Rechnung()

    // Kapselung der LiveData-Objekte:
    // Wir wollen nicht, dass von überall auf unsere LiveData-Objekte zugegriffen werden kann. Die Observer müssen aber auf diese zugreifen, damit sie diese beobachten können.
    // Deshalb Kapseln wir die Objekte und stellen eine "öffentliche" Variante der Objekte zur Verfügung:

    // ViewModel interne private Variablen - Diese werden mit einem Unterstrich gekennzeichnet - veränderbare MutableLiveData-Objekte.
    private var _aktuellesLiveDataErgebnis : MutableLiveData<Int> = MutableLiveData(rechnung.gibErgebnis())
    private var _bisherigesLiveDataErgebnis : MutableLiveData<Int> = MutableLiveData()

    // Öffentliche Variablen nach außen hin (View). Dies sind nicht veränderbare LiveData-Objekte und dienen zum aktualisieren der View.
    // Hierauf werden in der Activity die Observer gesetzt.
    val aktuellesLiveDataErgebnis : LiveData<Int>
        get() = _aktuellesLiveDataErgebnis
    val bisherigesLiveDataErgebnis : LiveData<Int>
        get() = _bisherigesLiveDataErgebnis


    fun rechnen(eingabe : Int){
        // Alt
        //bisherherigesErgebnis = rechnung.gibErgebnis()
        //aktuellesErgebnis = rechnung.rechnen(eingabe)

        // NEU mit LiveData - ACHTUNG!: MutableLiveData-Objekte können nur geändert werden, indem man den "value" des Objektes ändert. NICHT das Objekt selbst!
        // (siehe auch Kotlin: Backing-Field)
        //_bisherherigesErgebnisLiveData = rechnung.gibErgebnis()  <--- Falsch! Geht nicht!

        _bisherigesLiveDataErgebnis.value = rechnung.gibErgebnis()
        _aktuellesLiveDataErgebnis.value = rechnung.rechnen(eingabe)
    }

    fun zuruecksetzen(){
        rechnung.zurueckSetzen()
        _aktuellesLiveDataErgebnis.value = rechnung.gibErgebnis()
        _bisherigesLiveDataErgebnis.value = _aktuellesLiveDataErgebnis.value
    }
}