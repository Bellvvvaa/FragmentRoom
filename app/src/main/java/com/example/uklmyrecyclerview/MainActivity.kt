package com.example.uklmyrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class  MainActivity : AppCompatActivity() {
    private lateinit var et_email : EditText
    private lateinit var et_password : EditText
    private lateinit var bt_submit : Button
    private lateinit var bt_register : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
        bt_submit = findViewById(R.id.bt_submit)
        bt_register = findViewById(R.id.bt_register)

        bt_submit.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("email", et_email.text.toString())
            intent.putExtra("password", et_password.text.toString())
            startActivity(intent)
        }

        bt_register.setOnClickListener{
            val intent = Intent(this@MainActivity, SignUp::class.java)
            startActivity(intent)
        }

    }

}