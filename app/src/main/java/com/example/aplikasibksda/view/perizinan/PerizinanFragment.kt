package com.example.aplikasibksda.view.perizinan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aplikasibksda.databinding.FragmentPerizinanBinding
import com.example.aplikasibksda.util.Util

class PerizinanFragment : Fragment() {
    private var _binding: FragmentPerizinanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPerizinanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            binding.btnPenangkaran.setOnClickListener{
                val urlString = "https://ksdajateng.id/home/perizinan_blog?id=vCisgTlcBXA="
                openBrowser(urlString)
            }

            binding.btnPemanfaatanAir.setOnClickListener{
                val urlString = "https://ksdajateng.id/home/perizinan_blog?id=HDDsGph0x2E="
                openBrowser(urlString)
            }

            binding.btnPenerbitanIzin.setOnClickListener{
                val urlString = "https://ksdajateng.id/home/perizinan_blog?id=xgp7FjVC5rM="
                openBrowser(urlString)
            }

            binding.btnAngkutTumbuhan.setOnClickListener{
                val urlString = "https://ksdajateng.id/home/perizinan_blog?id=EGtWfiRxg9Q="
                openBrowser(urlString)
            }

            binding.btnRusa.setOnClickListener{
                val urlString = "https://ksdajateng.id/home/perizinan_blog?id=jA8mTxlYUk0="
                openBrowser(urlString)
            }
        }
    }

    private fun openBrowser(urlString: String){
        Util.openBrowser(urlString, binding.root.context)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}