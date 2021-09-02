package com.example.aplikasibksda.view.media

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasibksda.databinding.ItemYoutubeBinding
import com.example.aplikasibksda.util.Util
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubeThumbnailLoader
import com.google.android.youtube.player.YouTubeThumbnailLoader.OnThumbnailLoadedListener
import com.google.android.youtube.player.YouTubeThumbnailView

class MediaVideoAdapter(private val apiKey: String) : RecyclerView.Adapter<MediaVideoAdapter.ViewHolder>() {
    private val data = ArrayList<String>()

    fun setData(data: ArrayList<String>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemYoutubeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            with(binding) {
                ytPlayer.initialize(
                    apiKey,
                    object : YouTubeThumbnailView.OnInitializedListener {
                        override fun onInitializationSuccess(
                            youTubeThumbnailView: YouTubeThumbnailView,
                            youTubeThumbnailLoader: YouTubeThumbnailLoader
                        ) {
                            youTubeThumbnailLoader.setVideo(data)
                            youTubeThumbnailLoader.setOnThumbnailLoadedListener(object :
                                OnThumbnailLoadedListener {
                                override fun onThumbnailLoaded(
                                    youTubeThumbnailView: YouTubeThumbnailView,
                                    s: String
                                ) {
                                    //when thumbnail loaded successfully release the thumbnail loader as we are showing thumbnail in adapter
                                    youTubeThumbnailLoader.release()
                                }

                                override fun onThumbnailError(
                                    youTubeThumbnailView: YouTubeThumbnailView,
                                    errorReason: YouTubeThumbnailLoader.ErrorReason
                                ) {
                                    Toast.makeText(root.context, "$errorReason", Toast.LENGTH_SHORT).show()
                                }
                            })
                        }

                        override fun onInitializationFailure(
                            youTubeThumbnailView: YouTubeThumbnailView,
                            youTubeInitializationResult: YouTubeInitializationResult
                        ) {
                            Toast.makeText(root.context, "Gagal memuat data", Toast.LENGTH_SHORT).show()
                        }
                    })

                btnPlay.setOnClickListener{
                    val url = "https://www.youtube.com/watch?v=${data}"
                    Util.openYoutube(url, root.context)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemYoutubeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}