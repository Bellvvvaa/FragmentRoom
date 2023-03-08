package com.example.uklmyrecyclerview

object DataProduk {
    private val data = arrayOf(
        arrayOf(
           "Ayam Betutu",
            "Rp.35.000",
            "https://cdn-brilio-net.akamaized.net/news/2015/12/15/31760/121281-kuliner-ayam-1-3.jpg"
        ),arrayOf(
            "Ayam Taliwang",
            "Rp.25.000",
            "https://cdn-brilio-net.akamaized.net/news/2015/12/15/31760/121282-kuliner-ayam-1-3.jpg"
        )
    )

    val listData : ArrayList<Produk>
        get(){
            val list = arrayListOf<Produk>()
            for(aData in data){
                val ayam = Produk()
                ayam.name = aData[0]
                ayam.harga = aData[1]
                ayam.photo = aData[2]

                list.add(ayam)
            }
            return list
        }
}