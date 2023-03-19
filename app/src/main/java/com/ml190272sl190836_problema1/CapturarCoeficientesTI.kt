package com.ml190272sl190836_problema1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

lateinit var txtImprimirResultadosTI: TextView
lateinit var btnRegresarTI: Button

class CapturarCoeficientesTI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capturar_coeficientes_ti)

        txtImprimirResultadosTI = findViewById<TextView>(R.id.txtImprimirResultadosDI)
        btnRegresarTI = findViewById<Button>(R.id.btnRegresarDI)

        var bundle = intent.extras
        val x = bundle?.get("xo")
        val y = bundle?.get("yo")
        val z = bundle?.get("zo")
        txtImprimirResultadosTI.setText("x  =  $x; y  =  $y; z  =  $z")

        btnRegresarTI.setOnClickListener {

            intent = Intent(this, ResolverSistTresIncogs::class.java)
            startActivity(intent)
        }

    }
}