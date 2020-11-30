package com.example.dogssearchengine.ui.gallery


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.dogssearchengine.R
import com.example.dogssearchengine.data.DogImages
import com.example.dogssearchengine.databinding.ItemPhotoListBinding


class GalleryAdapter(private val listener: OnItemClickListener) :
    PagingDataAdapter<DogImages, GalleryAdapter.DogViewHolder>(IMAGE_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        //ItemUnsplashPhotoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val binding =
            ItemPhotoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }

    }

    //to access properties of the surrounding class we make it an inner class
    inner class DogViewHolder(private val binding: ItemPhotoListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        listener.onItemClick(item)
                    }
                }
            }
        }


        //access our views in a null and type safe way
        fun bind(photo: DogImages) {
            binding.apply {
                Glide.with(itemView)
                    .load(photo.urls.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(imageView)
                textViewUserName.text = photo.user.username
                textViewLikes.text = photo.likes.toString()
            }

        }
    }

    interface OnItemClickListener {
        fun onItemClick(photo: DogImages)
    }

    companion object {
        private val IMAGE_COMPARATOR = object : DiffUtil.ItemCallback<DogImages>() {
            override fun areItemsTheSame(oldItem: DogImages, newItem: DogImages) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: DogImages, newItem: DogImages) =
                oldItem == newItem
        }
    }


}
