package com.ml190272sl190836_problema1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal
import java.math.RoundingMode

lateinit var btnObtenerCoeficientesTI: Button
lateinit var txtCoeficiente1E1TI: EditText
lateinit var txtCoeficiente2E1TI: EditText
lateinit var txtCoeficiente3E1TI: EditText
lateinit var txtCoeficiente4E1TI: EditText
lateinit var txtCoeficiente1E2TI: EditText
lateinit var txtCoeficiente2E2TI: EditText
lateinit var txtCoeficiente3E2TI: EditText
lateinit var txtCoeficiente4E2TI: EditText
lateinit var txtCoeficiente1E3TI: EditText
lateinit var txtCoeficiente2E3TI: EditText
lateinit var txtCoeficiente3E3TI: EditText
lateinit var txtCoeficiente4E3TI: EditText
lateinit var txtAlertTI : TextView
lateinit var btnRegresarMTI : Button
class ResolverSistTresIncogs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resolver_sist_tres_incogs)

        txtCoeficiente1E1TI = findViewById(R.id.txtCoeficiente1E1TI)
        txtCoeficiente2E1TI = findViewById(R.id.txtCoeficiente2E1TI)
        txtCoeficiente3E1TI = findViewById(R.id.txtCoeficiente3E1TI)
        txtCoeficiente4E1TI = findViewById(R.id.txtCoeficiente4E1TI)
        txtCoeficiente1E2TI = findViewById(R.id.txtCoeficiente1E2TI)
        txtCoeficiente2E2TI = findViewById(R.id.txtCoeficiente2E2TI)
        txtCoeficiente3E2TI = findViewById(R.id.txtCoeficiente3E2TI)
        txtCoeficiente4E2TI = findViewById(R.id.txtCoeficiente4E2TI)
        txtCoeficiente1E3TI = findViewById(R.id.txtCoeficiente1E3TI)
        txtCoeficiente2E3TI = findViewById(R.id.txtCoeficiente2E3TI)
        txtCoeficiente3E3TI = findViewById(R.id.txtCoeficiente3E3TI)
        txtCoeficiente4E3TI = findViewById(R.id.txtCoeficiente4E3TI)
        txtAlertTI = findViewById(R.id.txtAlertaDI)
        btnObtenerCoeficientesTI = findViewById(R.id.btnObtenerCoeficientesTI)

        btnRegresarMTI = findViewById(R.id.btnRegresarMTI)
        btnRegresarMTI.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnObtenerCoeficientesTI.setOnClickListener {
            this.CalcularCoeficientesXYZK(
                txtCoeficiente1E1TI.text.toString().trim(),
                txtCoeficiente2E1TI.text.toString().trim(),
                txtCoeficiente3E1TI.text.toString().trim(),
                txtCoeficiente4E1TI.text.toString().trim(),
                txtCoeficiente1E2TI.text.toString().trim(),
                txtCoeficiente2E2TI.text.toString().trim(),
                txtCoeficiente3E2TI.text.toString().trim(),
                txtCoeficiente4E2TI.text.toString().trim(),
                txtCoeficiente1E3TI.text.toString().trim(),
                txtCoeficiente2E3TI.text.toString().trim(),
                txtCoeficiente3E3TI.text.toString().trim(),
                txtCoeficiente4E3TI.text.toString().trim(),
                txtAlertTI
            )
        }
    }

    @SuppressLint("SuspiciousIndentation")
    fun CalcularCoeficientesXYZK(
        x1: String,
        y1: String,
        z1: String,
        k1: String,
        x2: String,
        y2: String,
        z2: String,
        k2: String,
        x3: String,
        y3: String,
        z3: String,
        k3: String,
        Alerta: TextView
    ) {
        if (x1.toString().isEmpty() || y1.toString().isEmpty() || z1.toString()
                .isEmpty() || k1.toString().isEmpty() ||
            x2.toString().isEmpty() || y2.toString().isEmpty() || z2.toString()
                .isEmpty() || k2.toString().isEmpty() ||
            x3.toString().isEmpty() || y3.toString().isEmpty() || z3.toString()
                .isEmpty() || k3.toString().isEmpty()
        ) {
            Alerta.visibility = View.VISIBLE
        } else {

            /*
            convirtiendo variables a double, tendiendo en cuaeto :
            ax + by + cz = d
            ex + fy + gz = h
            ix + jy + kz = l
            */
            val a = x1.toDouble()
            val b = y1.toDouble()
            val c = z1.toDouble()
            val d = k1.toDouble()
            val e = x2.toDouble()
            val f = y2.toDouble()
            val g = z2.toDouble()
            val h = k2.toDouble()
            val i = x3.toDouble()
            val j = y3.toDouble()
            val k = z3.toDouble()
            val l = k3.toDouble()

            // declarando constantes con la abreviatura cons00

                if(a == "0".toDouble())
                {
                    txtAlertTI.text = "Ha ocurrido un error, prueba con otra matriz :)"
                    txtAlertTI.visibility = View.VISIBLE
                    txtAlertTI.invalidate()
                }
                else {
                    val cons01 = e / a
                    val cons02 = i / a
                    val cons03 = f - b * cons01
                    val cons04 = g - c * cons01
                    val cons05 = h - d * cons01
                    val cons06 = j - b * cons02
                    val cons07 = k - c * cons02
                    val cons08 = l - d * cons02
                    val cons09 = cons06 / cons03
                    val cons10 = cons08 - cons09 * cons05
                    val cons11 = cons07 - cons09 * cons04

                    // obteniendo los valores deconocidos y redondeandolos
                    val zo = cons10 / cons11
                    val yo = (cons05 - zo * cons04) / cons03
                    val xo = (1 / a) * (d - b * yo - c * zo)
                    val z = BigDecimal(zo).setScale(2, RoundingMode.HALF_EVEN)
                    val y = BigDecimal(yo).setScale(2, RoundingMode.HALF_EVEN)
                    val x = BigDecimal(xo).setScale(2, RoundingMode.HALF_EVEN)

                    val intent = Intent(this, CapturarCoeficientesTI::class.java)
                    intent.putExtra("xo", x)
                    intent.putExtra("yo", y)
                    intent.putExtra("zo", z)
                    startActivity(intent)
                }

        }
    }
}