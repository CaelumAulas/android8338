package br.com.caelum.twittelumapp.vm

import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumapp.modelo.Tweet
import br.com.caelum.twittelumapp.repository.TweetRepository

class TweetViewModel(private val repository: TweetRepository) : ViewModel() {

    fun lista() = repository.getLista()

    fun salva(tweet: Tweet) = repository.salva(tweet)

    fun exclui(tweet: Tweet) = repository.deleta(tweet)
}