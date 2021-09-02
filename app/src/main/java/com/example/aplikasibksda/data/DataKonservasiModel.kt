package com.example.aplikasibksda.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataKonservasiModel(
    var title: String = "",
    var desc: String = "",
    var url: String = "",
    var photo: String = ""
) : Parcelable
