package com.example.uklmyrecyclerview

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridProduk(private val listData: ArrayList<Produk>)
    :RecyclerView.Adapter<GridProduk.GridViewHolder>(){
    class GridViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_nama_produk)
        var tvHarga: TextView = itemView.findViewById(R.id.tv_harga)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GridViewHolder {
       val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.grid_produk, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val(name, harga, photo) = listData[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvHarga.text = harga
        holder.itemView.setOnClickListener{ Toast.makeText(holder.itemView.context,"Kamu Memilih " + listData[position].name, Toast.LENGTH_SHORT).show()}
    }

    override fun getItemCount(): Int {
       return listData.size
    }


}
