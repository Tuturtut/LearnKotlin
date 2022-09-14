package fr.Tuttur.NatureCollection

import android.app.appsearch.BatchResultCallback
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.Tuttur.NatureCollection.PlantRepository.Singleton.databaseRef
import fr.Tuttur.NatureCollection.PlantRepository.Singleton.plantList

class PlantRepository {

    object Singleton{
        val databaseRef = FirebaseDatabase.getInstance().getReference("plants")

        val plantList = arrayListOf<PlantModel>()
    }

    fun updateData(callback: () -> Unit){
         databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // retirer
                plantList.clear()

                // Recolter la liste
                for (ds in snapshot.children){
                    val plant = ds.getValue(PlantModel::class.java)

                    if (plant != null){
                        plantList.add(plant)
                    }
                }
                callback()

            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}