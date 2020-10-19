package co.basic.androidjetpackskeleton.ui.topRated

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.basic.androidjetpackskeleton.R
import co.basic.androidjetpackskeleton.activities.MovieDetailActivity
import co.basic.androidjetpackskeleton.adapters.RecyclerViewAdapter
import co.basic.androidjetpackskeleton.model.Data
import co.basic.androidjetpackskeleton.OnItemClickListener
import co.basic.androidjetpackskeleton.adapters.PagedMovieAdapter
import co.basic.androidjetpackskeleton.model.Movie
import java.util.ArrayList

class TopRatedFragment : Fragment(), OnItemClickListener {

    private lateinit var topRatedViewModel: TopRatedViewModel

    private var rvTopMovies: RecyclerView? = null
    private lateinit var topRatedAdapter: PagedMovieAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        topRatedViewModel =
            ViewModelProviders.of(this).get(TopRatedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_top_rated, container, false)

        rvTopMovies = root.findViewById(R.id.rv_top_rated)

        rvTopMovies!!.layoutManager = GridLayoutManager(context, 2)
        topRatedAdapter = PagedMovieAdapter(this)
        rvTopMovies!!.adapter = topRatedAdapter

        topRatedViewModel.topRatedMovies()
            .observe(viewLifecycleOwner, Observer { topRatedAdapter.submitList(it) })


        /**********example for without pagination************/

        /*topRatedViewModel.getTopMovies()?.observe(viewLifecycleOwner, {

            it?.let {

                adapter = context?.let { it1 -> RecyclerViewAdapter(it1, it.results,this) }
                rvTopMovies?.adapter = adapter
            }?.run { Toast.makeText(context, "Network Error!!", Toast.LENGTH_SHORT).show() }

        })*/


        return root
    }


    override fun <T> onItemClick(position: Int, data: T) {
        val itemData = data as Movie


        activity?.startActivity(
            Intent(activity, MovieDetailActivity::class.java)
                .putExtra("MOVIE_ID", itemData.id)
        )
    }


}