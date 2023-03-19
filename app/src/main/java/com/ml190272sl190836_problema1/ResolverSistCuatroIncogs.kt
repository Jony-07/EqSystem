package com.ml190272sl190836_problema1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

lateinit var btnObtenerCoeficientesCI: Button
lateinit var txtCoeficiente1E1CI: EditText
lateinit var txtCoeficiente2E1CI: EditText
lateinit var txtCoeficiente3E1CI: EditText
lateinit var txtCoeficiente4E1CI: EditText
lateinit var txtCoeficiente5E1CI: EditText
lateinit var txtCoeficiente1E2CI: EditText
lateinit var txtCoeficiente2E2CI: EditText
lateinit var txtCoeficiente3E2CI: EditText
lateinit var txtCoeficiente4E2CI: EditText
lateinit var txtCoeficiente5E2CI: EditText
lateinit var txtCoeficiente1E3CI: EditText
lateinit var txtCoeficiente2E3CI: EditText
lateinit var txtCoeficiente3E3CI: EditText
lateinit var txtCoeficiente4E3CI: EditText
lateinit var txtCoeficiente5E3CI: EditText
lateinit var txtCoeficiente1E4CI: EditText
lateinit var txtCoeficiente2E4CI: EditText
lateinit var txtCoeficiente3E4CI: EditText
lateinit var txtCoeficiente4E4CI: EditText
lateinit var txtCoeficiente5E4CI: EditText
lateinit var btnRegresarMCI: Button
lateinit var txtAlertaCI: TextView


class ResolverSistCuatroIncogs : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resolver_sist_cuatro_incogs)

        //Declarndo las matrices y vectores
        val matrizCoeficientes: Array<DoubleArray> = Array(4) { DoubleArray(4) }
        val matrizIndepentiente: DoubleArray = DoubleArray(4)
        val vectorResultados: DoubleArray = DoubleArray(4)

        btnObtenerCoeficientesCI = findViewById(R.id.btnObtenerCoeficientesCI)
        txtCoeficiente1E1CI = findViewById(R.id.txtCoeficiente1E1CI)
        txtCoeficiente2E1CI = findViewById(R.id.txtCoeficiente2E1CI)
        txtCoeficiente3E1CI = findViewById(R.id.txtCoeficiente3E1CI)
        txtCoeficiente4E1CI = findViewById(R.id.txtCoeficiente4E1CI)
        txtCoeficiente5E1CI = findViewById(R.id.txtCoeficiente5E1CI)
        txtCoeficiente1E2CI = findViewById(R.id.txtCoeficiente1E2CI)
        txtCoeficiente2E2CI = findViewById(R.id.txtCoeficiente2E2CI)
        txtCoeficiente3E2CI = findViewById(R.id.txtCoeficiente3E2CI)
        txtCoeficiente4E2CI = findViewById(R.id.txtCoeficiente4E2CI)
        txtCoeficiente5E2CI = findViewById(R.id.txtCoeficiente5E2CI)
        txtCoeficiente1E3CI = findViewById(R.id.txtCoeficiente1E3CI)
        txtCoeficiente2E3CI = findViewById(R.id.txtCoeficiente2E3CI)
        txtCoeficiente3E3CI = findViewById(R.id.txtCoeficiente3E3CI)
        txtCoeficiente4E3CI = findViewById(R.id.txtCoeficiente4E3CI)
        txtCoeficiente5E3CI = findViewById(R.id.txtCoeficiente5E3CI)
        txtCoeficiente1E4CI = findViewById(R.id.txtCoeficiente1E4CI)
        txtCoeficiente2E4CI = findViewById(R.id.txtCoeficiente2E4CI)
        txtCoeficiente3E4CI = findViewById(R.id.txtCoeficiente3E4CI)
        txtCoeficiente4E4CI = findViewById(R.id.txtCoeficiente4E4CI)
        txtCoeficiente5E4CI = findViewById(R.id.txtCoeficiente5E4CI)
        btnRegresarMCI = findViewById(R.id.btnRegresarMCI)
        txtAlertaCI = findViewById(R.id.txtAlertaCI)

        btnRegresarMCI.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnObtenerCoeficientesCI.setOnClickListener {


            if (txtCoeficiente1E1CI.text.isEmpty() || txtCoeficiente2E1CI.text.isEmpty() ||
                txtCoeficiente3E1CI.text.isEmpty() || txtCoeficiente4E1CI.text.isEmpty() ||
                txtCoeficiente5E1CI.text.isEmpty() || txtCoeficiente1E2CI.text.isEmpty() ||
                txtCoeficiente2E2CI.text.isEmpty() || txtCoeficiente3E2CI.text.isEmpty() ||
                txtCoeficiente4E2CI.text.isEmpty() || txtCoeficiente5E2CI.text.isEmpty() ||
                txtCoeficiente1E3CI.text.isEmpty() || txtCoeficiente2E3CI.text.isEmpty() ||
                txtCoeficiente3E3CI.text.isEmpty() || txtCoeficiente4E3CI.text.isEmpty() ||
                txtCoeficiente5E3CI.text.isEmpty() || txtCoeficiente1E4CI.text.isEmpty() ||
                txtCoeficiente2E4CI.text.isEmpty() || txtCoeficiente3E4CI.text.isEmpty() ||
                txtCoeficiente4E4CI.text.isEmpty() || txtCoeficiente5E4CI.text.isEmpty()
            ) {
                txtAlertaCI.text = "Todos los campos son obligatorios."
                txtAlertaCI.visibility = View.VISIBLE
                return@setOnClickListener
            }
            try {
                matrizCoeficientes[0][0] = txtCoeficiente1E1CI.text.toString().toDouble()
                matrizCoeficientes[0][1] = txtCoeficiente2E1CI.text.toString().toDouble()
                matrizCoeficientes[0][2] = txtCoeficiente3E1CI.text.toString().toDouble()
                matrizCoeficientes[0][3] = txtCoeficiente4E1CI.text.toString().toDouble()
                matrizCoeficientes[1][0] = txtCoeficiente1E2CI.text.toString().toDouble()
                matrizCoeficientes[1][1] = txtCoeficiente2E2CI.text.toString().toDouble()
                matrizCoeficientes[1][2] = txtCoeficiente3E2CI.text.toString().toDouble()
                matrizCoeficientes[1][3] = txtCoeficiente4E2CI.text.toString().toDouble()
                matrizCoeficientes[2][0] = txtCoeficiente1E3CI.text.toString().toDouble()
                matrizCoeficientes[2][1] = txtCoeficiente2E3CI.text.toString().toDouble()
                matrizCoeficientes[2][2] = txtCoeficiente3E3CI.text.toString().toDouble()
                matrizCoeficientes[2][3] = txtCoeficiente4E3CI.text.toString().toDouble()
                matrizCoeficientes[3][0] = txtCoeficiente1E4CI.text.toString().toDouble()
                matrizCoeficientes[3][1] = txtCoeficiente2E4CI.text.toString().toDouble()
                matrizCoeficientes[3][2] = txtCoeficiente3E4CI.text.toString().toDouble()
                matrizCoeficientes[3][3] = txtCoeficiente4E4CI.text.toString().toDouble()

                matrizIndepentiente[0] = txtCoeficiente5E1CI.text.toString().toDouble()
                matrizIndepentiente[1] = txtCoeficiente5E2CI.text.toString().toDouble()
                matrizIndepentiente[2] = txtCoeficiente5E3CI.text.toString().toDouble()
                matrizIndepentiente[3] = txtCoeficiente5E4CI.text.toString().toDouble()

                for (i in 0 until 3) {
                    //Buscando el pivote máximo en la columna i
                    var maxRow = i
                    for (j in i + 1 until 4) {
                        if (Math.abs(matrizCoeficientes[j][i]) > Math.abs(matrizCoeficientes[maxRow][i])) {
                            maxRow = j
                        }
                    }

                    // Intercambia la fila i con la fila del pivote máximo
                    for (j in i until 4) {
                        val temp = matrizCoeficientes[i][j]
                        matrizCoeficientes[i][j] = matrizCoeficientes[maxRow][j]
                        matrizCoeficientes[maxRow][j] = temp
                    }
                    val temp = matrizIndepentiente[i]
                    matrizIndepentiente[i] = matrizIndepentiente[maxRow]
                    matrizIndepentiente[maxRow] = temp


                    for (j in i + 1 until 4) {
                        val factor = matrizCoeficientes[j][i] / matrizCoeficientes[i][i]
                        for (k in i + 1 until 4) {
                            matrizCoeficientes[j][k] -= factor * matrizCoeficientes[i][k]
                        }
                        matrizIndepentiente[j] -= factor * matrizIndepentiente[i]
                    }
                }

                // Realizando la sustitución hacia atrás
                for (i in 3 downTo 0) {
                    var sum = 0.0
                    for (j in i + 1 until 4) {
                        sum += matrizCoeficientes[i][j] * vectorResultados[j]
                    }
                    vectorResultados[i] = (matrizIndepentiente[i] - sum) / matrizCoeficientes[i][i]
                }

                val vectorResultadosRedondeado = DoubleArray(4)
                for (i in vectorResultados.indices) {
                    vectorResultadosRedondeado[i] = "%.2f".format(vectorResultados[i]).toDouble()
                }
                // Muestra la solución en los TextView correspondientes

                val intent = Intent(this, CapturarCoeficientesCI::class.java)
                intent.putExtra("resultados", vectorResultadosRedondeado)
                startActivity(intent)
            }catch (e: Exception) {
                txtAlertaCI.setText("Se produjo una excepción: ${e.message}")
                txtAlertaCI.visibility = View.VISIBLE
            }


            }
        }
    }



