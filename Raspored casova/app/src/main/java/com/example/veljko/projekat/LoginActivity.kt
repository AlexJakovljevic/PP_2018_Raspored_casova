package com.example.veljko.projekat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    //ideja za skidanje podataka
    //ponuditi korisniku opciju da samo jednom skine raspored
    //skinuti raspored smestiti u bazu podataka i iz nje izvlaciti podatke


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //ako dobijemo flag iz poslednje aktivnosti, znaci da korisnik zeli da zatvori program
        if(intent.getBooleanExtra("EXIT", false)) finish()

        val btnNovi = findViewById<Button>(R.id.noviRaspored)
        val btnPostojeci = findViewById<Button>(R.id.postojeciRaspored)
        val db = Raspored(this)

        btnNovi.setOnClickListener ({
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        })
        btnPostojeci.setOnClickListener({
            val intent = Intent(this@LoginActivity, FifthActivity::class.java)
            val lista = db.readData()
            intent.putParcelableArrayListExtra("filtriraniCasoviIzPocetneAktivnosti" ,ArrayList(lista))
            startActivity(intent)
        })
    }
}