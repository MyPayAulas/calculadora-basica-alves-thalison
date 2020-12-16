package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        // numeros
        numero_zero.setOnClickListener {AcrescentarExpressao(string = "0",limpar_dados= true) }
        numero_um.setOnClickListener{AcrescentarExpressao(string = "1",limpar_dados = true) }
        numero_dois.setOnClickListener{AcrescentarExpressao(string = "2",limpar_dados = true) }
        numero_tres.setOnClickListener{AcrescentarExpressao(string = "3",limpar_dados = true) }
        numero_quatro.setOnClickListener{AcrescentarExpressao(string = "4",limpar_dados = true) }
        numero_cinco.setOnClickListener{AcrescentarExpressao(string = "5",limpar_dados = true) }
        numero_seis.setOnClickListener{AcrescentarExpressao(string = "6",limpar_dados = true) }
        numero_sete.setOnClickListener{AcrescentarExpressao(string = "7",limpar_dados = true) }
        numero_oito.setOnClickListener{AcrescentarExpressao(string = "8",limpar_dados = true) }
        numero_nove.setOnClickListener{AcrescentarExpressao(string = "9",limpar_dados = true) }
        ponto.setOnClickListener{AcrescentarExpressao(string = ".",limpar_dados = true) }

        //operadores
        adicao.setOnClickListener {AcrescentarExpressao(string = "+",limpar_dados= true)}
        subtracao.setOnClickListener {AcrescentarExpressao(string = "-",limpar_dados= true)}
        divisao.setOnClickListener {AcrescentarExpressao(string = "/",limpar_dados= true)}
        multiplicacao.setOnClickListener {AcrescentarExpressao(string = "*",limpar_dados= true)}
        adicao.setOnClickListener {AcrescentarExpressao(string = "+",limpar_dados= true)}

        //limpar
        limpar.setOnClickListener {
            Calculo.text = ""
            Resultado_t.text= ""
        }

         backspace.setOnClickListener {
             val string = Calculo.text.toString()
             if (string.isNotBlank()) {
                 Calculo.text = string.substring(0, string.length - 1)
             }
             Resultado_t.text = ""
         }

        igual.setOnClickListener{

            try {
                val calculo = ExpressionBuilder(Calculo.text.toString()).build()

                    val resultado = calculo.evaluate()
                    val longResult= resultado.toLong()


                if (resultado == longResult.toDouble()){
                    Resultado_t.text = longResult.toString()
                }else
                    Resultado_t.text = resultado.toString()

            }catch (e: Exception) {

            }
        }
    }



    fun AcrescentarExpressao(string: String, limpar_dados: Boolean){

        if (Resultado_t.text.isNotEmpty()){
                Calculo.text = ""

        }

        if (limpar_dados){
            Resultado_t.text =""
            Calculo.append(string)
        }else{
            Calculo.append(Resultado_t.text)
            Calculo.append(string)
            Resultado_t.text = ""
        }
    }

}