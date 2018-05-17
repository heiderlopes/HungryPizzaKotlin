package com.example.logonpf.hungrypizza

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detalhe_pedido.*


class DetalhePedidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_pedido)
        //Recebendo o pedido enviado pela tela anterior
        val pedido = intent.getParcelableExtra<Pedido>("pedido")

        tvNomeCliente.text = pedido.nomeCliente
        tvFormaPagamento.setText(
                getString(R.string.mensagem_pagamento,
                        pedido.valor, pedido.tipoPagamento)
        )
        for (sabor in pedido.sabores) {
            tvSabores.text = "${tvSabores.text}${sabor}\n"
        }
    }
}
