package com.example.aplikasibksda

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aplikasibksda.view.home.StartMenuFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = intent.getStringExtra(fragmentName)
        if(name != null){
            initView(name)
        }
    }

    private fun initView(name: String){
        if(name == startMenuFragment){
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.container, StartMenuFragment::class.java, null)
                .disallowAddToBackStack()
                .commit()
        }
    }

    companion object {
        const val fragmentName = "fragment name"
        const val startMenuFragment = "startMenuFragment"
    }
}