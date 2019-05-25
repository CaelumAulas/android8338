package br.com.caelum.twittelumapp.repository

import br.com.caelum.twittelumapp.db.TweetDao
import br.com.caelum.twittelumapp.modelo.Tweet

class TweetRepository(private val tweetDao: TweetDao) {

    fun salva(tweet: Tweet) = tweetDao.insere(tweet)

    fun getLista() = tweetDao.lista()

    fun deleta(tweet: Tweet) = tweetDao.deleta(tweet)

}