package com.example.aplikasibksda.view.konservasi

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aplikasibksda.data.DataKonservasiModel
import com.example.aplikasibksda.databinding.FragmentDetailKonservasiBinding
import com.example.aplikasibksda.util.Util

class DetailKonservasiFragment : Fragment() {
    private var _binding: FragmentDetailKonservasiBinding? = null
    private val binding get() = _binding!!

    companion object {
       const val KEY_DATA = "data"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailKonservasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data: DataKonservasiModel? = requireArguments().getParcelable(KEY_DATA)

        if(activity != null){
            if(data != null){
                with(binding){
                    Glide.with(root.context).load(data.photo).into(imgDetail)
                    tvDetailTitle.text = data.title
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        tvDetailDesc.text = Html.fromHtml(data.desc, Html.FROM_HTML_MODE_COMPACT)
                    } else {
                        tvDetailDesc.text = Html.fromHtml(data.desc)
                    }

                    tvDetailUrl.setOnClickListener {
                        Util.openBrowser(data.url, root.context)
                    }

                    buttonListener()
                }
            }
        }
    }

    private fun buttonListener(){
        with(binding){
            btnContact1.setOnClickListener {
                frameDetailBtn1.visibility = View.GONE
                tvDetailDesc.visibility = View.GONE
                frameDetailBtn2.visibility = View.VISIBLE
                tvDetailContact.visibility = View.VISIBLE
            }
            btnInformasi1.setOnClickListener {
                frameDetailBtn1.visibility = View.VISIBLE
                tvDetailDesc.visibility = View.VISIBLE
                frameDetailBtn2.visibility = View.GONE
                tvDetailContact.visibility = View.GONE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}