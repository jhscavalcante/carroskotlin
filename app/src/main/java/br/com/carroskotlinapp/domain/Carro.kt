package br.com.carroskotlinapp.domain

import android.graphics.Bitmap

class Carro (
    val modelo: String,
    val ano: Int,
    val marca: Marca,
    val motor: Motor,
    val preco: Float,
    val acessorios: List<Acessorio>,
    val imagem: Bitmap) {

    fun getAcessoriosFormatted(): String{
        val aux = StringBuilder()

        for (acessorio in acessorios)
            aux.append("${acessorio.nome}(${acessorio.preco}),")

        return aux.trimEnd().trimEnd(',').toString()
    }
}
