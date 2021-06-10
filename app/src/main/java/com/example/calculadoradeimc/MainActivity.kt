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

    }
}