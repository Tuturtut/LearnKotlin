package fr.Tuttur.NatureCollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.Tuttur.NatureCollection.fragments.HomeFragement

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction =  supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, HomeFragement())
        transaction.addToBackStack(null)
        transaction.commit()


    }
}