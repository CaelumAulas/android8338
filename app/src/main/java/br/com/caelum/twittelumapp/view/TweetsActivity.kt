package br.com.caelum.twittelumapp.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import br.com.caelum.twittelumapp.R
import br.com.caelum.twittelumapp.modelo.Tweet
import br.com.caelum.twittelumapp.vm.TweetViewModel
import br.com.caelum.twittelumapp.vm.ViewModelFactory
import kotlinx.android.synthetic.main.activity_tweets.*

class TweetsActivity : AppCompatActivity() {


    private val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweets)

        viewModel.lista().observe(this, Observer { tweets ->

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tweets)

            listaTweets.adapter = adapter

        })

        listaTweets.setOnItemClickListener { parent, view, position, id ->


            perguntaSePrecisaDeletarOTweetNaPosicao(position)

        }


        fab.setOnClickListener {

            val intencao = Intent(this, MainActivity::class.java)

            startActivity(intencao)

        }
    }

    private fun perguntaSePrecisaDeletarOTweetNaPosicao(position: Int) {

        val tweet = listaTweets.getItemAtPosition(position) as Tweet

        AlertDialog.Builder(this)
            .setTitle("Presta atenção")
            .setIcon(R.drawable.ic_warning)
            .setMessage("Você quer deletar o tweet com conteúdo: ${tweet.conteudo}")
            .setNegativeButton("Não", null)
            .setPositiveButton("Sim") { _, _ -> viewModel.exclui(tweet) }
            .show()


    }

}