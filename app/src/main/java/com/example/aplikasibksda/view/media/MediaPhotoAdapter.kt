package com.example.aplikasibksda.view.media

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aplikasibksda.databinding.ItemMediaBinding

class MediaPhotoAdapter: RecyclerView.Adapter<MediaPhotoAdapter.ViewHolder>() {
    private val data = ArrayList<String>()

    fun setData(data:ArrayList<String>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemMediaBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: String) {
            with(binding){
                Glide.with(root.context).load(data).into(imageMedia)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}