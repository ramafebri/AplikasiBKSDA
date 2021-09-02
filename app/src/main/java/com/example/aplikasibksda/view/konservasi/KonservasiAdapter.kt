package com.example.aplikasibksda.view.konservasi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aplikasibksda.data.DataKonservasiModel
import com.example.aplikasibksda.databinding.ItemKonservasiBinding

class KonservasiAdapter(private val clickListener: (DataKonservasiModel) -> Unit): RecyclerView.Adapter<KonservasiAdapter.ViewHolder>() {
    private val data = ArrayList<DataKonservasiModel>()

    fun setData(data:ArrayList<DataKonservasiModel>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemKonservasiBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: DataKonservasiModel) {
            with(binding){
                tvTitle.text = data.title
                Glide.with(root.context).load(data.photo).into(imageView)
                imageView.setOnClickListener {
                    clickListener(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemKonservasiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}