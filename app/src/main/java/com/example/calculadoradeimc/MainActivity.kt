package com.example.calculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoradeimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bt_calcular = binding.btCalcular
        val mensagem = binding.tvMensagem

        bt_calcular.setOnClickListener{
            val editPeso = binding.editPeso.text.toString()
            val editAltura = binding.editAltura.text.toString()

            if (editPeso.isEmpty()){
                mensagem.setText("Informe o Seu Peso")
            } else if (editAltura.isEmpty()){
                mensagem.setText("Informe a Sua Altura")
            } else {
                CalculoDeIMC()
            }
        }
    }
    private fun CalculoDeIMC(){

        val pesoID = binding.editPeso
        val alturaID = binding.editAltura
        val peso = Integer.parseInt(pesoID.text.toString())
        val altura = java.lang.Float.parseFloat(alturaID.text.toString())
        val resultado = binding.tvMensagem
        val imc = peso / (altura * altura)

        val Mensagem = when{
            imc <= 18.5 -> "Peso Baixo"
            imc <= 24.9 -> "Peso Normal"
            imc <= 29.9 -> "Sobrepeso"
            imc <= 34.9 -> "Obesidade (Grau 1)"
            imc <= 39.9 -> "Obesidade Severa (Grau 2)"
            else -> "Obesidade Mórbida (Grau 3)"
        }

        imc.toString()
        resultado.setText("IMC: $imc \n $Mensagem")

    }
}