package com.example.idadeapp

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
        val anoAtual = Calendar.getInstance().get(Calendar.YEAR)
        val anoNasc = etn_Idade.text.toString()
        if(anoNasc != ""){
            val resposta = anoAtual - anoNasc.toInt()
            val nome = ttp_Nome.text.toString().trim()
            val sobreNome = ttp_Sobrenome.text.toString()
            val ano = etn_Idade.text.toString()
            val camposValidos = validarCampos(nome,sobreNome,ano)
            if(camposValidos)
                respostaIdade(resposta.toString(),nome,sobreNome)
        }else {
            Toast.makeText(this, "O ano deve conter 4 digitos", Toast.LENGTH_SHORT).show()
        }



    }

    private fun respostaIdade(resposta: String,nome:String, sobreNome: String) {
        if (resposta > "18") {
            txv_Resposta.text = "${nome} ${sobreNome} a sua idade é : ${resposta} anos! Já pode dirigir!!"
            txv_Resposta.setTextColor(Color.GREEN)
        } else if (resposta < "18") {
            txv_Resposta.text = "${nome} ${sobreNome} a sua idade é : ${resposta} anos! Você ainda é menor de idade!"
            txv_Resposta.setTextColor(Color.BLUE)
        }
    }

    private fun  validarCampos(nome: String, sobreNome : String , ano : String):Boolean {
        if (nome.length < 3) {
            Toast.makeText(this, "O nome deve ser maior que 3 digitos", Toast.LENGTH_SHORT).show()
            return false
        }
        if(nome.equals("")){
            Toast.makeText(this, "O nome nao pode ser vazio", Toast.LENGTH_SHORT).show()
            return false
        }
        if (sobreNome.length < 3) {
            Toast.makeText(this, "O sobrenome deve ser maior que 3 digitos", Toast.LENGTH_SHORT).show()
            return false
        }
        if(sobreNome.equals("")){
            Toast.makeText(this, "O sobrenome nao pode ser vazio", Toast.LENGTH_SHORT).show()
            return false
        }
        if(ano.equals("") ){
            Toast.makeText(this, "O ano nao pode ser vazio", Toast.LENGTH_SHORT).show()
            return false
        }
        if(ano.length != 4 ){
            Toast.makeText(this, "O ano deve conter 4 digitos", Toast.LENGTH_SHORT).show()
            return false
        }
       return true
    }
}