package com.example.logonpf.hungrypizza

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    //Clique do botão
    fun logar(view: View) {
        //Recuperar os valores digitados
        val login = etLogin.text.toString()
        val senha = etSenha.text.toString()

        //Valida o usuário e senha
        if (login == "FIAP" && senha == "123") {
            //Mudar de tela                Tela de Destino
            val intent = Intent(this, PedidoActivity::class.java)
            //Passar uma valor para a outra tela
            intent.putExtra("usuario", login)
            //Iniciar a outra tela
            startActivity(intent)
            finish()
        } else {
            //Login ou senha inválidos
            Toast.makeText(this, "Usuário ou senha inválidos",
                    Toast.LENGTH_SHORT).show()
        }
    }
}
