package com.ml190272sl190836_problema1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

lateinit var txtImprimirResultadosCI: TextView
lateinit var btnRegresarCI : Button

class CapturarCoeficientesCI : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capturar_coeficientes_ci)

        txtImprimirResultadosCI = findViewById<TextView>(R.id.txtImprimirResultadosDI)
        btnRegresarCI = findViewById<Button>(R.id.btnRegresarDI)

        val resultados = intent.getDoubleArrayExtra("resultados")
        txtImprimirResultadosCI.setText(resultados?.joinToString (" ;   "))


        btnRegresarCI.setOnClickListener {
                val intent = Intent(this, ResolverSistCuatroIncogs::class.java)
                startActivity(intent)
        }
    }
}