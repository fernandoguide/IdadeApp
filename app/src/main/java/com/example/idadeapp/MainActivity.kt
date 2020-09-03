package com.example.idadeapp

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun enviar(view: View) {
        txv_Resposta.setTextColor(Color.BLACK)
        val anoNasicmento = Calendar.getInstance().get(Calendar.YEAR)
        val resposta = anoNasicmento - etn_Idade.text.toString().toInt()
        val nome = ttp_Nome.text.toString()
        val sobreNome = ttp_Sobrenome.text.toString()
        val ano = etn_Idade.text.toString()
        validarCampos(nome , sobreNome , ano )

        respostaIdade(resposta)
    }

    private fun respostaIdade(resposta: Int) {
        if (resposta > 18) {
            txv_Resposta.text = "A sua idade é : ${resposta} anos! Já pode dirigir!!"
            txv_Resposta.setTextColor(Color.RED)
        } else if (resposta < 18) {
            txv_Resposta.text = "A sua idade é : ${resposta} anos! Você ainda é menor de idade!"
            txv_Resposta.setTextColor(Color.BLUE)
        }
    }

    private fun validarCampos(nome: String, sobreNome : String , ano : String) {
        if (nome.length < 3) {
            Toast.makeText(this, "O nome deve ser maior que 3 digitos", Toast.LENGTH_SHORT).show()
        }
        if(nome.equals("")){
            Toast.makeText(this, "O nome nao pode ser vazio", Toast.LENGTH_SHORT).show()
        }
        if(ano.equals("") ){
            Toast.makeText(this, "O nome nao pode ser vazio", Toast.LENGTH_SHORT).show()
        }
    }
}