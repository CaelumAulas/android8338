package br.com.caelum.twittelumapp.app

import android.app.Application

class TwittelumApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        application = this

    }


    companion object {

        private lateinit var application: TwittelumApplication

        fun getInstance(): TwittelumApplication {
            return application
        }
    }
}