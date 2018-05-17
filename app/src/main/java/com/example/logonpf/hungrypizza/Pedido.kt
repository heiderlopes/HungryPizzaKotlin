package com.example.logonpf.hungrypizza

import android.os.Parcel
import android.os.Parcelable

data class Pedido(val nomeCliente: String,
                  val sabores: List<String>,
                  val tamanho: String,
                  val tipoPagamento: String,
                  val valor: Double) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.createStringArrayList(),
            parcel.readString(),
            parcel.readString(),
            parcel.readDouble())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nomeCliente)
        parcel.writeStringList(sabores)
        parcel.writeString(tamanho)
        parcel.writeString(tipoPagamento)
        parcel.writeDouble(valor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pedido> {
        override fun createFromParcel(parcel: Parcel): Pedido {
            return Pedido(parcel)
        }

        override fun newArray(size: Int): Array<Pedido?> {
            return arrayOfNulls(size)
        }
    }
}
