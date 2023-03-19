package com.ml190272sl190836_problema1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

lateinit var txtImprimirCoeficientes: TextView
lateinit var btnRegresarActividadAnterior: Button

class CapturarCoeficientes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capturar_coeficientes)

        txtImprimirCoeficientes = findViewById<TextView>(R.id.txtImprimirResultadosDI)
        btnRegresarActividadAnterior = findViewById<Button>(R.id.btnRegresarDI)
        var bundle = intent.extras
        val x = bundle?.get("xo")
        val y = bundle?.get("yo")
        txtImprimirCoeficientes.setText("x = $x; y = $y")

        btnRegresarActividadAnterior.setOnClickListener {

            intent = Intent(this, ResolverSistDosIncogs::class.java)
            startActivity(intent)
        }
    }

}
