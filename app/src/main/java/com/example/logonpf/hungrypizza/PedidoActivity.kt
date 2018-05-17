package com.example.logonpf.hungrypizza

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AlertDialog
import android.view.View
import kotlinx.android.synthetic.main.activity_pedido.*

class PedidoActivity : AppCompatActivity() {

    val pizzasSelecionadas = ArrayList<String>()
    var tamanhoSelecionado = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        //Recuperar o valor informado pela tela de Login
        val bundle = intent.extras
        val usuario = bundle.getString("usuario")

        //Alterar o texto de boas vindas
        tvUsuario.text = "Olá $usuario"
    }

    //Clique do botão
    fun calcular(view: View) {
        //Recuperar o ID do RadioButton Selecionado
        val idSelecionado = rgTamanhoPizza.checkedRadioButtonId
        var valorTamanhoPizza = 0
        var valor = 0.0

        when (idSelecionado) {
            R.id.rbPequena -> {
                valorTamanhoPizza = 10
                tamanhoSelecionado = rbPequena.text.toString()
            }
            R.id.rbMedia -> {
                valorTamanhoPizza = 12
                tamanhoSelecionado = rbMedia.text.toString()
            }
            R.id.rbGrande -> {
                valorTamanhoPizza = 15
                tamanhoSelecionado = rbGrande.text.toString()
            }
        }

        if (cbAtum.isChecked) {
            valor += (3 + valorTamanhoPizza).toDouble()
            pizzasSelecionadas.add(cbAtum.text.toString())
        }

        if (cbBacon.isChecked) {
            valor += (5 + valorTamanhoPizza).toDouble()
            pizzasSelecionadas.add(cbBacon.text.toString())
        }

        if (cbCalabresa.isChecked) {
            valor += (4 + valorTamanhoPizza).toDouble()
            pizzasSelecionadas.add(cbCalabresa.text.toString())
        }

        if (cbMussarela.isChecked) {
            valor += (2 + valorTamanhoPizza).toDouble()
            pizzasSelecionadas.add(cbMussarela.text.toString())
        }

        //Recuperar o pagamento selecionado
        val pagamento = spPagamentos.selectedItem as String

        //Exibir a confirmação do pedido
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Confirmação")
        alert.setMessage("Valor: $valor\nPagamento: $pagamento")

        alert.setPositiveButton("SIM", DialogInterface.OnClickListener { dialog, which ->
            /*Log.i("Pedido", "Confirmação de Pedido")
            Toast.makeText(this@PedidoActivity, "Pedido Confirmado!",
                    Toast.LENGTH_SHORT).show()*/


            val intentDetalhePedido = Intent(this, DetalhePedidoActivity::class.java)
            val pedido = Pedido(etNomeCliente.text.toString(),
                    pizzasSelecionadas,
                    tamanhoSelecionado,
                    spPagamentos.selectedItem.toString(),
                    valor)
            intentDetalhePedido.putExtra("pedido", pedido)

            startActivity(intentDetalhePedido)
        })
        alert.setNegativeButton("NÃO", null)
        alert.show()
    }
}
