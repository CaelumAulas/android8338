package br.com.caelum.twittelumapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_tweets.*

class TweetsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweets)

        val tweets = arrayListOf("Meu primeiro tweet", "Meu segundo tweet", "Meu terceiro tweet", "Meu quarto tweet")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tweets)

        listaTweets.adapter = adapter

        fab.setOnClickListener {

            val intencao = Intent(this, MainActivity::class.java)

            startActivity(intencao)

        }
    }
}