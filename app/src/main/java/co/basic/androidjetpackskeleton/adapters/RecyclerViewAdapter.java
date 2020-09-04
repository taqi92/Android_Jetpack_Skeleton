package co.basic.androidjetpackskeleton.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.basic.androidjetpackskeleton.R;
import co.basic.androidjetpackskeleton.model.Data;
import co.basic.androidjetpackskeleton.networking.ApiClient;
import co.basic.androidjetpackskeleton.networking.ApiInterface;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private Context context;
    private ArrayList<Data> dataList;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public RecyclerViewAdapter(Context context, ArrayList<Data> dataList) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.dataList = dataList;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.raw_recyclerview_item, parent, false);
        return new RecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {


        Log.d("image_url",dataList.get(viewHolder.getAdapterPosition()).getPosterPath());


        String image = dataList.get(position).getPosterPath().substring(1);
        final int id = dataList.get(position).getId();


        Picasso.get().load(ApiClient.IMAGE_URL+image).into(viewHolder.ivListItem);


    }


    // total number of rows
    @Override
    public int getItemCount() {
        return dataList.size();
    }



    // stores and recycles views as they are scrolled off screen
    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivListItem;


        ViewHolder(View itemView) {
            super(itemView);

            ivListItem = itemView.findViewById(R.id.iv_list_item);

        }
    }
}