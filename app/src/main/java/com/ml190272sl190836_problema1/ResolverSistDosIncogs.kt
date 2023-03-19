package com.ml190272sl190836_problema1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal
import java.math.RoundingMode

lateinit var btnObtenerCoeficientesDI: Button
lateinit var txtCoeficiente1E1DI: EditText
lateinit var txtCoeficiente2E1DI: EditText
lateinit var txtCoeficiente3E1DI: EditText
lateinit var txtCoeficiente1E2DI: EditText
lateinit var txtCoeficiente2E2DI: EditText
lateinit var txtCoeficiente3E2DI: EditText
lateinit var txtImprimirAlertaD: TextView
lateinit var btnRegresarMDI: TextView

class ResolverSistDosIncogs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resolver_sist_dos_incogs)

        txtCoeficiente1E1DI = findViewById(R.id.txtCoeficiente1E1DI)
        txtCoeficiente2E1DI = findViewById(R.id.txtCoeficiente2E1DI)
        txtCoeficiente3E1DI = findViewById(R.id.txtCoeficiente3E1DI)
        txtCoeficiente1E2DI = findViewById(R.id.txtCoeficiente1E2DI)
        txtCoeficiente2E2DI = findViewById(R.id.txtCoeficiente2E2DI)
        txtCoeficiente3E2DI = findViewById(R.id.txtCoeficiente3E2DI)
        btnObtenerCoeficientesDI = findViewById<Button>(R.id.btnObtenerCoeficientesDI)
        txtImprimirAlertaD = findViewById(R.id.txtAlertaDI)
        btnRegresarMDI = findViewById(R.id.btnRegresarMDI)

        btnRegresarMDI.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnObtenerCoeficientesDI.setOnClickListener {
            this.CalcularCoeficientesXYK(
                txtCoeficiente1E1DI.text.toString().trim(),
                txtCoeficiente2E1DI.text.toString().trim(),
                txtCoeficiente3E1DI.text.toString().trim(),
                txtCoeficiente1E2DI.text.toString().trim(),
                txtCoeficiente2E2DI.text.toString().trim(),
                txtCoeficiente3E2DI.text.toString().trim(),
                txtImprimirAlertaD
            )
        }
    }

    fun CalcularCoeficientesXYK(
        x1: String,
        y1: String,
        k1: String,
        x2: String,
        y2: String,
        k2: String,
        txtImprimirAlertaD: TextView
    ) {
        if (x1.toString().isEmpty() || y1.toString().isEmpty() || k1.toString()
                .isEmpty() || x2.toString().isEmpty() || y2.toString().isEmpty() || k2.toString()
                .isEmpty()
        ) {
            txtImprimirAlertaD.text = "Debe ingresar todos los valores"
            txtImprimirAlertaD.visibility = View.VISIBLE
            txtImprimirAlertaD.invalidate()
        } else {

            /*
            convirtiendo variables a double, tendiendo en cuento :
            ax + by = c
            dx + ey = f
            */
            try {
                val a = x1.toDouble()
                val b = y1.toDouble()
                val c = k1.toDouble()
                val d = x2.toDouble()
                val e = y2.toDouble()
                val f = k2.toDouble()

                // la abreviatura cons00 hará referencia a valores constantes
                // declaramos constantes que nos serviran para obtener los valores x ^ y
                if (a == "0".toDouble()) {
                    val yo = c / b
                    val xo = (f - e * yo) / d
                    val y = BigDecimal(yo).setScale(2, RoundingMode.HALF_EVEN)
                    val x = BigDecimal(xo).setScale(2, RoundingMode.HALF_EVEN)
                    val intent = Intent(this, CapturarCoeficientes::class.java)
                    intent.putExtra("xo", x)
                    intent.putExtra("yo", y)
                    startActivity(intent)
                } else {
                    val cons01 = d / a
                    val cons02 = f - cons01 * c
                    val cons03 = e - cons01 * b
                    val cons04 = 1 / a

                    // obteniendo los valores finales y redondeando a dos decimales
                    val yo = cons02 / cons03
                    val y = BigDecimal(yo).setScale(2, RoundingMode.HALF_EVEN)
                    val xo = cons04 * (c - b * yo)
                    val x = BigDecimal(xo).setScale(2, RoundingMode.HALF_EVEN)


                    val intent = Intent(this, CapturarCoeficientes::class.java)
                    intent.putExtra("xo", x)
                    intent.putExtra("yo", y)

                    startActivity(intent)
                }

            }catch (e: Exception) {
                Log.d("Error","Se produjo una excepción: ${e.message}")

            }
        }
    }
}






