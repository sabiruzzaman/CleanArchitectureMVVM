package com.longitude23.cleanarchitecturemvvm.presentation.image_list

import android.annotation.SuppressLint
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.longitude23.cleanarchitecturemvvm.R
import com.longitude23.cleanarchitecturemvvm.databinding.ItemImagesBinding
import com.longitude23.cleanarchitecturemvvm.domain.model.Images

class ImageListAdapter(val context: Context) :
    RecyclerView.Adapter<ImageListAdapter.ImageListViewHolder>() {

    private var imageList: List<Images> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(imageList: List<Images>) {
        this.imageList = imageList
        notifyDataSetChanged()
    }

    class ImageListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemImagesBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_images, parent, false)
        return ImageListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {

        val images = imageList[position]

        with(holder.binding) {
            nameId.text = images.author
            Glide.with(context).load(images.download_url).into(imageViewId)
        }

    }

    override fun getItemCount(): Int {
        return imageList.size
    }


}