package com.example.aplikasibksda.view.simaksi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aplikasibksda.databinding.FragmentSimaksiBinding
import com.example.aplikasibksda.util.Util


class SimaksiFragment : Fragment() {
    private var _binding: FragmentSimaksiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSimaksiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            binding.btnFilm.setOnClickListener{
                val urlString = "http://36.67.9.26/new/simaksi-a.php"
                openBrowser(urlString)
            }

            binding.btnPendidikan.setOnClickListener{
                val urlString = "http://36.67.9.26/new/simaksi-b.php"
                openBrowser(urlString)
            }

            binding.btnPenelitian.setOnClickListener{
                val urlString = "http://36.67.9.26/new/simaksi-c.php"
                openBrowser(urlString)
            }

            binding.btnReligi.setOnClickListener{
                val urlString = "http://36.67.9.26/new/simaksi-d.php"
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