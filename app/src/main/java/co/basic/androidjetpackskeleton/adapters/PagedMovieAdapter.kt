package co.basic.androidjetpackskeleton.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import co.basic.androidjetpackskeleton.R
import co.basic.androidjetpackskeleton.model.Movie
import co.basic.androidjetpackskeleton.networking.ApiClient
import co.basic.androidjetpackskeleton.ui.newRelease.OnItemClickListener
import com.squareup.picasso.Picasso

class PagedMovieAdapter(val listener: OnItemClickListener) :
    PagedListAdapter<Movie, PagedMovieAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: ItemCallback<Movie> = object : ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.equals(newItem)

        }
    }

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.raw_recyclerview_item, parent, false)
        )
    }

    override fun onBindViewHolder(viewHolder: ItemViewHolder, position: Int) {

        //Picasso.get().load(ApiClient.IMAGE_URL + image).into(viewHolder.ivListItem)
        //TODO: Show image poster

        viewHolder.itemView.setOnClickListener {

            listener.onItemClick(
                viewHolder.adapterPosition,
                getItem(position)
            )
        }
    }


    class ItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        var ivListItem: ImageView

        init {
            ivListItem = itemView.findViewById(R.id.iv_list_item)
        }
    }
}