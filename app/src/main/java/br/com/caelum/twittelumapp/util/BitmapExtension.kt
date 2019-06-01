package br.com.caelum.twittelumapp.util

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream

fun Bitmap.encodeToBase64(): String {

    val byteArrayOutputStream = ByteArrayOutputStream()

    this.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)

    val arrayDeBytes = byteArrayOutputStream.toByteArray()

    return Base64.encodeToString(arrayDeBytes, Base64.DEFAULT)
}
