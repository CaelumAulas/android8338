package br.com.caelum.twittelumapp.view

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import br.com.caelum.twittelumapp.R
import br.com.caelum.twittelumapp.modelo.Tweet
import br.com.caelum.twittelumapp.util.encodeToBase64
import br.com.caelum.twittelumapp.vm.TweetViewModel
import br.com.caelum.twittelumapp.vm.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class FormularioActivity : AppCompatActivity() {

    private var caminho: String? = null

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

            R.id.menu_main_foto -> tiraFoto()

            android.R.id.home -> finish()

        }

        return true

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                carregaImagem()
            } else {
                Toast.makeText(this, "Voce nao quis tirar uma foto ? ", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun carregaImagem() {
        cardView.visibility = View.VISIBLE

        val bitmap = BitmapFactory.decodeFile(caminho)

        val bitmapTratado = Bitmap.createScaledBitmap(bitmap, 400, 300, true)

        val base64 = bitmapTratado.encodeToBase64()

        tweetFoto.tag = base64

        tweetFoto.setImageBitmap(bitmapTratado)

        tweetFoto.scaleType = ImageView.ScaleType.FIT_XY
    }

    private fun tiraFoto() {
        val vaiParaCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        val uri = defineUri()

        vaiParaCamera.putExtra(MediaStore.EXTRA_OUTPUT, uri)

        startActivityForResult(vaiParaCamera, 1)
    }

    private fun defineUri(): Uri? {
        caminho = "${getExternalFilesDir("imagens")}/${System.currentTimeMillis()}.jpg"

        val arquivo = File(caminho)

        return FileProvider.getUriForFile(this, "MeuProvider", arquivo)
    }

    private fun publicaTweet() {

        val conteudo = msgTweet.text.toString()

        val foto = tweetFoto.tag as String?

        val tweet = Tweet(conteudo, foto)

        viewModel.salva(tweet)

        Toast.makeText(this, tweet.toString(), Toast.LENGTH_SHORT).show()

        finish()

    }
}
