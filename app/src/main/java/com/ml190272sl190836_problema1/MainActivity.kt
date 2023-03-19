package com.ml190272sl190836_problema1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

lateinit var btnSistDosIncogs : Button
lateinit var btnSistTresIncogs : Button
lateinit var btnSistCuatroIncogs : Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSistDosIncogs = findViewById(R.id.btnSistDosIncogs)
        btnSistTresIncogs = findViewById(R.id.btnSistTresIncogs)
        btnSistCuatroIncogs = findViewById(R.id.btnSistCuatroIncogs)

        btnSistDosIncogs.setOnClickListener {
            val intent = Intent(this,ResolverSistDosIncogs::class.java)
            startActivity(intent)
        }
        btnSistTresIncogs.setOnClickListener {
            val intent = Intent(this,ResolverSistTresIncogs::class.java)
            startActivity(intent)
        }
        btnSistCuatroIncogs.setOnClickListener {
            val intent = Intent(this,ResolverSistCuatroIncogs::class.java)
            startActivity(intent)
        }


    }
}