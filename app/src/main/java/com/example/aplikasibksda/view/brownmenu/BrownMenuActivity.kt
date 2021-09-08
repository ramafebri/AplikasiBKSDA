package com.example.aplikasibksda.view.brownmenu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aplikasibksda.MainActivity
import com.example.aplikasibksda.databinding.ActivityBrownMenuBinding
import com.example.aplikasibksda.view.ExitActivity
import com.example.aplikasibksda.view.mainmenu.MainMenuActivity
import com.example.aplikasibksda.view.mainmenu.TabName

class BrownMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBrownMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrownMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            imageClose.setOnClickListener{
                finish()
            }

            tvBrownHome.setOnClickListener{
                val intent = Intent(root.context, MainActivity::class.java)
                intent.putExtra(MainActivity.fragmentName, MainActivity.startMenuFragment)
                startActivity(intent)
                finish()
            }

            tvBrownProfil.setOnClickListener{
                gotoMainMenuActivity(TabName.PROFIL.value)
            }

            tvBrownKonservasi.setOnClickListener{
                gotoMainMenuActivity(TabName.KONSERVASI.value)
            }

            tvBrownPerizinan.setOnClickListener{
                gotoMainMenuActivity(TabName.PERIZINAN.value)
            }

            tvBrownInformasi.setOnClickListener{
                gotoMainMenuActivity(TabName.INFORMASI.value)
            }

            tvBrownSimaksi.setOnClickListener{
                gotoMainMenuActivity(TabName.SIMAKSI.value)
            }

            tvBrownTaman.setOnClickListener{
                gotoMainMenuActivity(TabName.TAMAN.value)
            }

            tvBrownMedia.setOnClickListener{
                gotoMainMenuActivity(TabName.MEDIA.value)
            }

            tvBrownKontak.setOnClickListener{
                gotoMainMenuActivity(TabName.KONTAK.value)
            }

            tvBrownKeluar.setOnClickListener{
                startActivity(Intent(binding.root.context, ExitActivity::class.java))
            }
        }
    }

    private fun gotoMainMenuActivity(selectedTabName: String){
        val intent = Intent(this, MainMenuActivity::class.java)
        intent.putExtra(MainMenuActivity.selectedTabName, selectedTabName)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}