package br.com.caelum.twittelumapp.vm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caelum.twittelumapp.app.TwittelumApplication
import br.com.caelum.twittelumapp.db.TwittelumDatabase
import br.com.caelum.twittelumapp.repository.TweetRepository

object ViewModelFactory : ViewModelProvider.Factory{


    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val database = TwittelumDatabase.getInstance(TwittelumApplication.getInstance())

        val tweetDao = database.getTweetDao()

        val repository = TweetRepository(tweetDao)

        return TweetViewModel(repository) as T
    }
}