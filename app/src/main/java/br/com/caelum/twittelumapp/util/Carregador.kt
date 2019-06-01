package br.com.caelum.twittelumapp.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

object Carregador {

    fun decodifica(foto: String): Bitmap {

        val bytes = Base64.decode(foto, Base64.DEFAULT)

        val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)

        return bitmap

    }
}