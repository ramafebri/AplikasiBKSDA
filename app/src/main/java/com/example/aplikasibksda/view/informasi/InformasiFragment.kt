package com.example.aplikasibksda.view.informasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aplikasibksda.databinding.FragmentInformasiBinding

class InformasiFragment : Fragment() {
    private var _binding: FragmentInformasiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInformasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            buttonListener()
        }
    }

    private fun buttonListener(){
        with(binding){
            btnAnnounce1.setOnClickListener {
                frameInformasiBtn1.visibility = View.GONE
                layoutPublik.visibility = View.GONE
                frameInformasiBtn2.visibility = View.VISIBLE
                layoutPengumuman.visibility = View.VISIBLE
            }
            btnPublic1.setOnClickListener {
                frameInformasiBtn1.visibility = View.VISIBLE
                layoutPublik.visibility = View.VISIBLE
                frameInformasiBtn2.visibility = View.GONE
                layoutPengumuman.visibility = View.GONE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}