package co.basic.androidjetpackskeleton.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import co.basic.androidjetpackskeleton.R
import co.basic.androidjetpackskeleton.model.Data
import co.basic.androidjetpackskeleton.networking.ApiClient
import co.basic.androidjetpackskeleton.ui.newRelease.NewReleaseFragmentDirections
import com.squareup.picasso.Picasso
import java.util.*

public class RecyclerViewAdapter(private val context: Context, dataList: ArrayList<Data>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val dataList: ArrayList<Data>
    private val mInflater: LayoutInflater

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.raw_recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val image = dataList[position].posterPath.substring(1)
        val id = dataList[position].id
        Picasso.get().load(ApiClient.IMAGE_URL + image).into(viewHolder.ivListItem)
    }

    // total number of rows
    override fun getItemCount(): Int {
        return dataList.size
    }

    // stores and recycles views as they are scrolled off screen
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivListItem: ImageView

        init {
            ivListItem = itemView.findViewById(R.id.iv_list_item)

            ivListItem.setOnClickListener {

                val action = NewReleaseFragmentDirections.actionNavigationNewReleaseToMovieDetailActivity(2)

                Navigation.findNavController(itemView).navigate(action)
            }

        }
    }

    // data is passed into the constructor
    init {
        mInflater = LayoutInflater.from(context)
        this.dataList = dataList
    }
}