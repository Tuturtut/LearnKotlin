package fr.Tuttur.NatureCollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.Tuttur.NatureCollection.MainActivity
import fr.Tuttur.NatureCollection.PlantRepository.Singleton.plantList
import fr.Tuttur.NatureCollection.R
import fr.Tuttur.NatureCollection.adapter.PlantAdapter
import fr.Tuttur.NatureCollection.adapter.PlantItemDecoration

class HomeFragement(
    private val context:MainActivity
): Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =inflater.inflate(R.layout.fragement_home, container, false)


        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_horizontal_plant)

        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_vertical_plant)
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())


        return view
    }

}