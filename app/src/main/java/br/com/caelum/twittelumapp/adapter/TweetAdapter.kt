package br.com.caelum.twittelumapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.caelum.twittelumapp.R
import br.com.caelum.twittelumapp.modelo.Tweet
import br.com.caelum.twittelumapp.util.Carregador
import kotlinx.android.synthetic.main.item_tweet.view.*

class TweetAdapter(private val tweets: List<Tweet>) : BaseAdapter() {


    override fun getCount(): Int {
        return tweets.size
    }

    override fun getItem(position: Int): Any {
        return tweets[position]
    }

    override fun getItemId(position: Int): Long {
        return tweets[position].id
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {

        val tweet = tweets[position]

        val inflater: LayoutInflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.item_tweet, parent, false)


        view.item_conteudo.text = tweet.conteudo


        tweet.foto?.let { foto ->
            view.item_foto.visibility = View.VISIBLE

            view.item_foto.setImageBitmap(Carregador.decodifica(foto))

        }


        return view


    }

}
