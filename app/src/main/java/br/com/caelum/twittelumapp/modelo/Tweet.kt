package br.com.caelum.twittelumapp.modelo

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Tweet(
    val conteudo: String,
    val foto: String? = null,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
) {

    override fun toString(): String {
        return conteudo
    }
}