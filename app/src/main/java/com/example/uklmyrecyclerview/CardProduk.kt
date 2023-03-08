package com.example.uklmyrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardProduk (private val listData: ArrayList<Produk>)
    : RecyclerView.Adapter<CardProduk.CardViewHolder>() {
    class CardViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_nama_produk)
        var tvHarga: TextView = itemView.findViewById(R.id.tv_harga)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cardview_produk, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val (name, harga, photo) = listData[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvHarga.text = harga

        holder.btnFavorite.setOnClickListener {Toast.makeText(holder.itemView.context, "Favorite"+listData[position].name,Toast.LENGTH_SHORT).show() }
        holder.btnShare.setOnClickListener{Toast.makeText(holder.itemView.context,"Share"+listData[position].name,Toast.LENGTH_SHORT).show()}
        holder.itemView.setOnClickListener{Toast.makeText(holder.itemView.context,"Kamu Memilih"+listData[position].name,Toast.LENGTH_SHORT).show()}

    }

    override fun getItemCount(): Int {
        return listData.size
    }

}