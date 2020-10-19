package co.basic.androidjetpackskeleton.ui.upcoming

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
import co.basic.androidjetpackskeleton.adapters.RecyclerViewAdapter
import co.basic.androidjetpackskeleton.model.Data
import co.basic.androidjetpackskeleton.OnItemClickListener
import co.basic.androidjetpackskeleton.activities.MovieDetailActivity
import co.basic.androidjetpackskeleton.adapters.PagedMovieAdapter
import co.basic.androidjetpackskeleton.model.Movie
import java.util.ArrayList

class UpcomingFragment : Fragment(), OnItemClickListener {

    private lateinit var upcomingViewModel: UpcomingViewModel

    private var rvUpcoming: RecyclerView? = null
    private lateinit var upcomingMovieAdapter: PagedMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        upcomingViewModel =
            ViewModelProviders.of(this).get(UpcomingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_upcoming, container, false)


        rvUpcoming = root.findViewById(R.id.rv_upcoming)
        rvUpcoming!!.layoutManager = GridLayoutManager(context, 2)

        upcomingMovieAdapter = PagedMovieAdapter(this)
        rvUpcoming!!.adapter = upcomingMovieAdapter


        upcomingViewModel.getUpcomingMovies()?.observe(viewLifecycleOwner, Observer { upcomingMovieAdapter.submitList(it) })

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