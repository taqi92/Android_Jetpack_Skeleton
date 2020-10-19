package co.basic.androidjetpackskeleton.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import co.basic.androidjetpackskeleton.R
import co.basic.androidjetpackskeleton.model.Data
import co.basic.androidjetpackskeleton.networking.ApiClient
import co.basic.androidjetpackskeleton.OnItemClickListener
import com.squareup.picasso.Picasso
import java.util.*

class RecyclerViewAdapter(
    private val context: Context,
    dataList: ArrayList<Data>,
    private val listener: OnItemClickListener
) :

    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    interface ClickListener {

        fun onClickListener(item: ArrayList<Data>)
    }


    private val dataList: ArrayList<Data>
    private val mInflater: LayoutInflater

    var id: Int = 1


    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.raw_recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val image = dataList[position].posterPath.substring(1)
        id = dataList[position].id


        Picasso.get().load(ApiClient.IMAGE_URL + image).into(viewHolder.ivListItem)

        viewHolder.itemView.setOnClickListener {

            listener.onItemClick(
                viewHolder.adapterPosition,
                dataList.get(viewHolder.adapterPosition)
            )


        }


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

        }
    }

    // data is passed into the constructor
    init {
        mInflater = LayoutInflater.from(context)
        this.dataList = dataList
    }
}

