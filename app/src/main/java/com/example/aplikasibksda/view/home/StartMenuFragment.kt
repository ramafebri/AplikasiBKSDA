package com.example.aplikasibksda.view.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.aplikasibksda.databinding.FragmentMenuBinding
import com.example.aplikasibksda.view.ExitActivity
import com.example.aplikasibksda.view.mainmenu.MainMenuActivity
import com.example.aplikasibksda.view.mainmenu.TabName

class StartMenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finishAffinity()
                }
            })

        binding.btnProfile.setOnClickListener{
            gotoMainMenuActivity(TabName.PROFIL.value)
        }

        binding.btnAreaKonservasi.setOnClickListener{
            gotoMainMenuActivity(TabName.KONSERVASI.value)
        }

        binding.btnPerizinan.setOnClickListener{
            gotoMainMenuActivity(TabName.PERIZINAN.value)
        }

        binding.btnInformasi.setOnClickListener{
            gotoMainMenuActivity(TabName.INFORMASI.value)
        }

        binding.btnSimaksi.setOnClickListener{
            gotoMainMenuActivity(TabName.SIMAKSI.value)
        }

        binding.btnWistaAlam.setOnClickListener{
            gotoMainMenuActivity(TabName.TAMAN.value)
        }

        binding.btnMedia.setOnClickListener{
            gotoMainMenuActivity(TabName.MEDIA.value)
        }

        binding.btnKontak.setOnClickListener{
            gotoMainMenuActivity(TabName.KONTAK.value)
        }

        binding.btnExit.setOnClickListener{
            startActivity(Intent(binding.root.context, ExitActivity::class.java))
        }
    }

    private fun gotoMainMenuActivity(selectedTabName: String){
        val intent = Intent(context, MainMenuActivity::class.java)
        intent.putExtra(MainMenuActivity.selectedTabName, selectedTabName)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}