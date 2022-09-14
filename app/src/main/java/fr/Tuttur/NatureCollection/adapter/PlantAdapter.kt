package fr.Tuttur.NatureCollection.adapter

import android.media.Image
import android.media.ImageWriter
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.Tuttur.NatureCollection.MainActivity
import fr.Tuttur.NatureCollection.PlantModel
import fr.Tuttur.NatureCollection.R

class PlantAdapter (
    private val context: MainActivity,
    private val plantList: List<PlantModel>,
    private val layoutId: Int
    ) : RecyclerView.Adapter<PlantAdapter.ViewHolder>(){

    // Boite Pour ranger tout les composant a controler
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val plantImage = view.findViewById<ImageView>(R.id.image_item)
        val plantName:TextView? = view.findViewById(R.id.name_item)
        val plantDescription:TextView? = view.findViewById(R.id.description_item)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Recuperer les information de la plantes
        val currentPlant = plantList[position]
        Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)

        holder.plantName?.text = currentPlant.name

        holder.plantDescription?.text = currentPlant.description

        // Verifier s'il y a eu like on non
        if(currentPlant.isLiked){
            holder.starIcon.setImageResource(R.drawable.ic_like)
        } else {
            holder.starIcon.setImageResource(R.drawable.ic_unlike)
        }
    }

    override fun getItemCount(): Int = plantList.size



}