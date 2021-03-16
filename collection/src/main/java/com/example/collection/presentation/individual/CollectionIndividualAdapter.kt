package com.example.collection.presentation.individual

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collection.RTAG
import com.example.collection.databinding.ImageItemViewBinding
import com.example.collection.databinding.ImagePlantPhotoViewBinding
import com.example.collection.presentation.overview.CollectionOverviewAdapter
import com.example.storage.data.PlantIndividual
import com.example.storage.data.PlantPhoto

class CollectionIndividualAdapter : ListAdapter<PlantPhoto,
        CollectionIndividualAdapter.PlantPhotoViewHolder>(DiffCallback) {

    val TAG: String = "CollectionIndividualAdapter"
    val debug1 = "DEBUG1"

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlantPhotoViewHolder {
        Log.d(debug1, "in onCreateViewHolder")
        return PlantPhotoViewHolder(
            ImagePlantPhotoViewBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: PlantPhotoViewHolder,
        position: Int
    ) {
        Log.d(debug1, "in iNDIVIDUAL onBindViewHolder")
        val plantPhoto = getItem(position)
        holder.bind(plantPhoto)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PlantPhoto>() {
        override fun areItemsTheSame(oldItem: PlantPhoto, newItem: PlantPhoto): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PlantPhoto, newItem: PlantPhoto): Boolean {
            return oldItem.plantId == newItem.plantId
        }
    }

    class PlantPhotoViewHolder(private var binding:
                                    ImagePlantPhotoViewBinding
    ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(plantPhoto: PlantPhoto) {
            Log.d("DEBUG1", "in INDIVIDUAL bind function in PlantPhotoViewHolder")
            binding.plantPhoto = plantPhoto
            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (plantPhoto:PlantPhoto) -> Unit) {
        fun onClick(plantPhoto: PlantPhoto) = clickListener(plantPhoto)
    }
}