package br.com.caelum.twittelumapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.com.caelum.twittelumapp.modelo.Tweet

@Database(entities = [Tweet::class], version = 1)
abstract class TwittelumDatabase : RoomDatabase() {

    abstract fun getTweetDao(): TweetDao

    companion object {

        private var database: TwittelumDatabase? = null

        fun getInstance(contexto: Context): TwittelumDatabase {

            return database ?: criaDatabase(contexto).also { bancoCriado ->
                database = bancoCriado
            }
        }

        private fun criaDatabase(contexto: Context): TwittelumDatabase {

            return Room
                .databaseBuilder(contexto, TwittelumDatabase::class.java, "TwittelumDB")
                .allowMainThreadQueries()
                .build()

        }

    }
}