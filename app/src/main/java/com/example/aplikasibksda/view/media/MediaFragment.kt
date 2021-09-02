package com.example.aplikasibksda.view.media

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasibksda.BuildConfig
import com.example.aplikasibksda.data.DataMedia
import com.example.aplikasibksda.databinding.FragmentMediaBinding

class MediaFragment : Fragment() {
    private var _binding: FragmentMediaBinding? = null
    private val binding get() = _binding!!
    private val adapterPhoto = MediaPhotoAdapter()
    private var dataPhoto = ArrayList<String>()
    private var dataYoutube = ArrayList<String>()

    private val youtubeKey = BuildConfig.YOUTUBE_KEY
    private val adapterVideo = MediaVideoAdapter(youtubeKey)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMediaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            getData()
            initView()
        }
    }

    private fun initView(){
        with(binding){
            rvMedia.layoutManager = LinearLayoutManager(context)
            rvMedia.adapter = adapterPhoto
            adapterPhoto.setData(dataPhoto)

            rvYoutube.layoutManager = LinearLayoutManager(context)
            rvYoutube.adapter = adapterVideo
            adapterVideo.setData(dataYoutube)
        }
        buttonListener()
    }

    private fun buttonListener(){
        with(binding){
            btnVideo1.setOnClickListener {
                frameMediaBtn1.visibility = View.GONE
                rvMedia.visibility = View.GONE
                frameMediaBtn2.visibility = View.VISIBLE
                rvYoutube.visibility = View.VISIBLE
            }
            btnPhoto1.setOnClickListener {
                frameMediaBtn1.visibility = View.VISIBLE
                rvMedia.visibility = View.VISIBLE
                frameMediaBtn2.visibility = View.GONE
                rvYoutube.visibility = View.GONE
            }
        }
    }

    private fun getData(){
        dataPhoto = DataMedia.listMedia
        dataYoutube = DataMedia.listYoutube
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}