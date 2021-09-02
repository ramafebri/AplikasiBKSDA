package com.example.aplikasibksda.view.kontak

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aplikasibksda.databinding.FragmentKontakBinding
import com.example.aplikasibksda.util.Util

class KontakFragment : Fragment() {
    private var _binding: FragmentKontakBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKontakBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            with(binding){
                tvAlamat.setOnClickListener{
                    Util.openMaps(root.context)
                }

                btnMail.setOnClickListener{
                    openMail()
                }

                tvMail.setOnClickListener{
                    openMail()
                }

                btnPhone.setOnClickListener{
                    dialPhone()
                }

                tvPhone.setOnClickListener{
                    dialPhone()
                }

                btnIg.setOnClickListener{
                    val urlString = "https://www.instagram.com/bksda_jateng/"
                    openBrowser(urlString)
                }

                btnFb.setOnClickListener{
                    val urlString = "https://www.facebook.com/bksdajawatengah/"
                    openBrowser(urlString)
                }

                btnYoutube.setOnClickListener{
                    val urlString = "https://www.youtube.com/channel/UC_N80_zZTIw4N-SzETOyxPQ"
                    openBrowser(urlString)
                }

                btnWeb.setOnClickListener{
                    val urlString = "https://ksdajateng.id/"
                    openBrowser(urlString)
                }
            }
        }
    }

    private fun openMail(){
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("bksda_jateng@yahoo.co.id"))
        }
        startActivity(emailIntent)
    }

    private fun dialPhone(){
        val phoneNumber = "0247614752"
        val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(dialPhoneIntent)
    }

    private fun openBrowser(urlString: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlString))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage(null)
        requireContext().startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}