package com.example.uklmyrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListProduk(private val listData: ArrayList<Produk>) : RecyclerView.Adapter<ListProduk.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_nama_produk)
        var tvHarga: TextView = itemView.findViewById(R.id.tv_harga)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_produk, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       val (name, harga, photo) = listData[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPhoto)
            holder.tvName.text= name
        holder.tvHarga.text = harga
        holder.itemView.setOnClickListener{ Toast.makeText(holder.itemView.context,"Kamu Memilih " + listData[position].name, Toast.LENGTH_SHORT).show()}
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}