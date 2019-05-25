package br.com.caelum.twittelumapp.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.com.caelum.twittelumapp.R
import br.com.caelum.twittelumapp.modelo.Tweet
import br.com.caelum.twittelumapp.vm.TweetViewModel
import br.com.caelum.twittelumapp.vm.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val itemId = item.itemId

        when (itemId) {
            R.id.menu_main_salvar -> {
                publicaTweet()
            }

            android.R.id.home -> finish()

        }

        return true

    }

    private fun publicaTweet() {

        val conteudo = msgTweet.text.toString()

        val tweet = Tweet(conteudo)

        viewModel.salva(tweet)

        Toast.makeText(this, tweet.toString(), Toast.LENGTH_SHORT).show()

        finish()

    }
}
