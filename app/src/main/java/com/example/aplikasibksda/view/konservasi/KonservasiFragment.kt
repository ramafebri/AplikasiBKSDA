package com.example.aplikasibksda.view.konservasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aplikasibksda.R
import com.example.aplikasibksda.data.DataKonservasi
import com.example.aplikasibksda.data.DataKonservasiModel
import com.example.aplikasibksda.databinding.FragmentKonservasiBinding
import com.example.aplikasibksda.util.Util

class KonservasiFragment : Fragment() {
    private var _binding: FragmentKonservasiBinding? = null
    private val binding get() = _binding!!
    private val adapter = KonservasiAdapter(::onClick)
    private var data = ArrayList<DataKonservasiModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKonservasiBinding.inflate(inflater, container, false)
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
            val layoutManager = GridLayoutManager(context, 4)
            if(Util.isDataOdd(data)){
                layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return when (position) {
                            data.size-1 -> 4
                            else -> 2
                        }
                    }
                }
            }
            rvKonservasi.layoutManager = layoutManager
            rvKonservasi.adapter = adapter
            adapter.setData(data)
        }
    }

    private fun onClick(konservasiData: DataKonservasiModel){
        val data = Bundle()
        data.putParcelable(DetailKonservasiFragment.KEY_DATA, konservasiData)
        val detailKonservasiFragment = DetailKonservasiFragment()
        detailKonservasiFragment.arguments = data

        requireActivity()
            .supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentFrame, detailKonservasiFragment)
            .commit()
    }

    private fun getData(){
        data = DataKonservasi.listDataKonservasi
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}