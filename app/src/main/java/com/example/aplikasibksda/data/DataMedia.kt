package com.example.aplikasibksda.data

object DataMedia {
    private val images = arrayOf(
        "https://i.ibb.co/dLYj893/img-media1.png",
        "https://i.ibb.co/k13gbR7/img-media2.png",
        "https://i.ibb.co/bWGnxGC/img-media3.png",
        "https://i.ibb.co/wKn0Sk0/img-media4.png",
        "https://i.ibb.co/BfFHX1F/img-media5.png",
        "https://i.ibb.co/DbPpH0Q/img-media6.png",
        "https://i.ibb.co/1npVxmc/img-media7.png",
        "https://i.ibb.co/qY6dxBN/img-media8.png",
        "https://i.ibb.co/1qzK9Fw/img-media9.png",
    )

    private val youtubeCode = arrayOf(
        "TRGp7UZvK6I",
        "MSBAnYT1Jig",
        "qh6F21yXye4",
    )

    val listMedia: ArrayList<String>
        get() {
            val list = arrayListOf<String>()
            for (position in images.indices) {
                list.add(images[position])
            }
            return list
        }

    val listYoutube: ArrayList<String>
        get() {
            val list = arrayListOf<String>()
            for (position in youtubeCode.indices) {
                list.add(youtubeCode[position])
            }
            return list
        }
}