package com.example.uklmyrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    private lateinit var rvProduk: RecyclerView
    private var list:ArrayList<Produk> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rvProduk = findViewById(R.id.list_produk)
        rvProduk.setHasFixedSize(true)

        list.addAll(DataProduk.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvProduk.layoutManager = LinearLayoutManager(this)
        val listProduk = ListProduk(list)
        rvProduk.adapter = listProduk
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode:Int){
        when(selectedMode){
            R.id.action_list-> {
                showRecyclerList()
            }
            R.id.action_grid ->{
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                showRecyclerCardView()
            }
        }
    }

    private fun showRecyclerGrid(){
        rvProduk.layoutManager = GridLayoutManager(this,2)
        val gridProduk = GridProduk(list)
        rvProduk.adapter = gridProduk
    }

    private fun showRecyclerCardView(){
        rvProduk.layoutManager = LinearLayoutManager(this)
        val cardProduk = CardProduk(list)
        rvProduk.adapter = cardProduk
    }
}