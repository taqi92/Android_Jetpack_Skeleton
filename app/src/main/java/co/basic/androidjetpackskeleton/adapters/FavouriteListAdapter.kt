package co.basic.androidjetpackskeleton.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import co.basic.androidjetpackskeleton.R
import co.basic.androidjetpackskeleton.room.FavMoviePoster
import com.squareup.picasso.Picasso

class FavouriteListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<FavouriteListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<FavMoviePoster>() // Cached copy of words

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var wordItemView: ImageView = itemView.findViewById(R.id.ivfav)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {

        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {

        val current = words[position]

        //holder.wordItemView = current.word

        Picasso.get().load(current.word).into(holder.wordItemView)
    }

    internal fun setWords(words: List<FavMoviePoster>) {
        this.words = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = words.size
}