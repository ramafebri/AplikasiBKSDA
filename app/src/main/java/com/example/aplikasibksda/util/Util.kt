package com.example.aplikasibksda.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.aplikasibksda.data.DataKonservasiModel
import android.content.pm.ResolveInfo

import android.content.pm.PackageManager

import android.content.ComponentName
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import java.util.*
import kotlin.collections.ArrayList


object Util {
    fun openBrowser(urlString: String, context: Context){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlString))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage("com.android.chrome")
        try {
            context.startActivity(intent)
        } catch (ex: ActivityNotFoundException) {
            intent.setPackage(null)
            context.startActivity(intent)
        }
    }

    fun openYoutube(urlString: String, context: Context){
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(urlString)
        )
        intent.setPackage("com.google.android.youtube")
        try {
            context.startActivity(intent)
        } catch (ex: ActivityNotFoundException) {
            intent.setPackage(null)
            context.startActivity(intent)
        }
    }

    fun openMaps(context: Context){
        val uri: String = java.lang.String.format(
            Locale.getDefault(),
            "http://maps.google.com/maps?q=loc:%f,%f",
            -6.9992387,
            110.3870502
        )
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        context.startActivity(intent)
    }

    fun isDataOdd(data: ArrayList<DataKonservasiModel>): Boolean{
        return data.size % 2 == 1
    }
}