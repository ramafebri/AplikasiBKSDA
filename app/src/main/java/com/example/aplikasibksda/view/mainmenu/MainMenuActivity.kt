package com.example.aplikasibksda.view.mainmenu

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasibksda.R
import com.example.aplikasibksda.databinding.ActivityMainMenuBinding
import com.example.aplikasibksda.view.brownmenu.BrownMenuActivity
import com.example.aplikasibksda.view.informasi.InformasiFragment
import com.example.aplikasibksda.view.konservasi.KonservasiFragment
import com.example.aplikasibksda.view.kontak.KontakFragment
import com.example.aplikasibksda.view.media.MediaFragment
import com.example.aplikasibksda.view.perizinan.PerizinanFragment
import com.example.aplikasibksda.view.profile.ProfileFragment
import com.example.aplikasibksda.view.simaksi.SimaksiFragment
import com.example.aplikasibksda.view.taman.TamanFragment

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding
    private lateinit var viewModel: MainMenuViewModel

    companion object{
        const val selectedTabName = "selectedTabName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainMenuViewModel::class.java)

        val nameTab = intent.getStringExtra(selectedTabName)
        if(nameTab != null){
            initView(nameTab)
        } else {
            viewModel.setSelectedTab(TabName.PROFIL)
        }
        selectedTab()
        setListener()
        supportActionBar?.elevation = 0f
    }

    private fun initView(nameTab: String) {
        when (nameTab)
        {
            TabName.PROFIL.value -> viewModel.setSelectedTab(TabName.PROFIL)
            TabName.KONSERVASI.value -> viewModel.setSelectedTab(TabName.KONSERVASI)
            TabName.INFORMASI.value -> viewModel.setSelectedTab(TabName.INFORMASI)
            TabName.MEDIA.value -> viewModel.setSelectedTab(TabName.MEDIA)
            TabName.SIMAKSI.value -> viewModel.setSelectedTab(TabName.SIMAKSI)
            TabName.TAMAN.value -> viewModel.setSelectedTab(TabName.TAMAN)
            TabName.PERIZINAN.value -> viewModel.setSelectedTab(TabName.PERIZINAN)
            TabName.KONTAK.value -> viewModel.setSelectedTab(TabName.KONTAK)
            else -> {}
        }
    }

    private fun selectedTab(){
        viewModel.selectedTab.observe(this, { tabName ->
            when (tabName)
            {
                TabName.PROFIL -> showProfileFragment(tabName.value)
                TabName.KONSERVASI -> showKonservasiFragment(tabName.value)
                TabName.INFORMASI -> showInformasiFragment(tabName.value)
                TabName.MEDIA -> showMediaFragment(tabName.value)
                TabName.SIMAKSI -> showSimaksiFragment(tabName.value)
                TabName.TAMAN -> showTamanFragment(tabName.value)
                TabName.PERIZINAN -> showPerizinanFragment(tabName.value)
                TabName.KONTAK -> showKontakFragment(tabName.value)
                else -> {}
            }
        })
    }

    private fun setListener(){
        with(binding){
            tvTabProfil.setOnClickListener{viewModel.setSelectedTab(TabName.PROFIL)}
            tvTabKonservasi.setOnClickListener{viewModel.setSelectedTab(TabName.KONSERVASI)}
            tvTabInformasi.setOnClickListener{viewModel.setSelectedTab(TabName.INFORMASI)}
            tvTabPerizinan.setOnClickListener{viewModel.setSelectedTab(TabName.PERIZINAN)}
            tvTabMedia.setOnClickListener{viewModel.setSelectedTab(TabName.MEDIA)}
            tvTabTaman.setOnClickListener{viewModel.setSelectedTab(TabName.TAMAN)}
            tvTabSimaksi.setOnClickListener{viewModel.setSelectedTab(TabName.SIMAKSI)}
            tvTabKontak.setOnClickListener{viewModel.setSelectedTab(TabName.KONTAK)}
            btnBurgerMenu.setOnClickListener{startActivity(Intent(root.context, BrownMenuActivity::class.java))}
        }
    }

    private fun scrollTo(tv: TextView){
        binding.horizontalScrollView.post {
            binding.horizontalScrollView.smoothScrollTo(tv.left, 0)
        }
    }

    private fun showProfileFragment(name: String){
        clearSelection()
        binding.tvTitleSelected.text = name
        binding.tvTabProfil.setTextColor(Color.parseColor("#000000"))
        binding.tvTabProfil.setTypeface(null, Typeface.BOLD)
        binding.tvTabProfil.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_bold, null)
        scrollTo(binding.tvTabProfil)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentFrame, ProfileFragment::class.java, null)
            .disallowAddToBackStack()
            .commit()
    }

    private fun showKonservasiFragment(name: String){
        clearSelection()
        binding.tvTitleSelected.text = name
        binding.tvTabKonservasi.setTextColor(Color.parseColor("#000000"))
        binding.tvTabKonservasi.setTypeface(null, Typeface.BOLD)
        binding.tvTabKonservasi.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_bold, null)
        scrollTo(binding.tvTabKonservasi)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentFrame, KonservasiFragment::class.java, null)
            .disallowAddToBackStack()
            .commit()
    }

    private fun showPerizinanFragment(name: String){
        clearSelection()
        binding.tvTitleSelected.text = name
        binding.tvTabPerizinan.setTextColor(Color.parseColor("#000000"))
        binding.tvTabPerizinan.setTypeface(null, Typeface.BOLD)
        binding.tvTabPerizinan.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_bold, null)
        scrollTo(binding.tvTabPerizinan)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentFrame, PerizinanFragment::class.java, null)
            .disallowAddToBackStack()
            .commit()
    }

    private fun showInformasiFragment(name: String){
        clearSelection()
        binding.tvTitleSelected.text = name
        binding.tvTabInformasi.setTextColor(Color.parseColor("#000000"))
        binding.tvTabInformasi.setTypeface(null, Typeface.BOLD)
        binding.tvTabInformasi.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_bold, null)
        scrollTo(binding.tvTabInformasi)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentFrame, InformasiFragment::class.java, null)
            .disallowAddToBackStack()
            .commit()
    }

    private fun showMediaFragment(name: String){
        clearSelection()
        binding.tvTitleSelected.text = name
        binding.tvTabMedia.setTextColor(Color.parseColor("#000000"))
        binding.tvTabMedia.setTypeface(null, Typeface.BOLD)
        binding.tvTabMedia.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_bold, null)
        scrollTo(binding.tvTabMedia)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentFrame, MediaFragment::class.java, null)
            .disallowAddToBackStack()
            .commit()
    }

    private fun showSimaksiFragment(name: String){
        clearSelection()
        binding.tvTitleSelected.text = name
        binding.tvTabSimaksi.setTextColor(Color.parseColor("#000000"))
        binding.tvTabSimaksi.setTypeface(null, Typeface.BOLD)
        binding.tvTabSimaksi.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_bold, null)
        scrollTo(binding.tvTabSimaksi)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentFrame, SimaksiFragment::class.java, null)
            .disallowAddToBackStack()
            .commit()
    }

    private fun showKontakFragment(name: String){
        clearSelection()
        binding.tvTitleSelected.text = name
        binding.tvTabKontak.setTextColor(Color.parseColor("#000000"))
        binding.tvTabKontak.setTypeface(null, Typeface.BOLD)
        binding.tvTabKontak.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_bold, null)
        scrollTo(binding.tvTabKontak)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentFrame, KontakFragment::class.java, null)
            .disallowAddToBackStack()
            .commit()
    }

    private fun showTamanFragment(name: String){
        clearSelection()
        binding.tvTitleSelected.text = name
        binding.tvTabTaman.setTextColor(Color.parseColor("#000000"))
        binding.tvTabTaman.setTypeface(null, Typeface.BOLD)
        binding.tvTabTaman.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_bold, null)
        scrollTo(binding.tvTabTaman)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentFrame, TamanFragment::class.java, null)
            .disallowAddToBackStack()
            .commit()
    }

    private fun clearSelection(){
        binding.tvTabProfil.setTextColor(Color.parseColor("#808080"))
        binding.tvTabProfil.setTypeface(null, Typeface.NORMAL)
        binding.tvTabProfil.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_light, null)

        binding.tvTabKonservasi.setTextColor(Color.parseColor("#808080"))
        binding.tvTabKonservasi.setTypeface(null, Typeface.NORMAL)
        binding.tvTabKonservasi.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_light, null)

        binding.tvTabPerizinan.setTextColor(Color.parseColor("#808080"))
        binding.tvTabPerizinan.setTypeface(null, Typeface.NORMAL)
        binding.tvTabPerizinan.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_light, null)

        binding.tvTabInformasi.setTextColor(Color.parseColor("#808080"))
        binding.tvTabInformasi.setTypeface(null, Typeface.NORMAL)
        binding.tvTabInformasi.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_light, null)

        binding.tvTabMedia.setTextColor(Color.parseColor("#808080"))
        binding.tvTabMedia.setTypeface(null, Typeface.NORMAL)
        binding.tvTabMedia.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_light, null)

        binding.tvTabTaman.setTextColor(Color.parseColor("#808080"))
        binding.tvTabTaman.setTypeface(null, Typeface.NORMAL)
        binding.tvTabTaman.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_light, null)

        binding.tvTabSimaksi.setTextColor(Color.parseColor("#808080"))
        binding.tvTabSimaksi.setTypeface(null, Typeface.NORMAL)
        binding.tvTabSimaksi.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_light, null)

        binding.tvTabKontak.setTextColor(Color.parseColor("#808080"))
        binding.tvTabKontak.setTypeface(null, Typeface.NORMAL)
        binding.tvTabKontak.background = ResourcesCompat.getDrawable(resources, R.drawable.top_border_light, null)
    }
}