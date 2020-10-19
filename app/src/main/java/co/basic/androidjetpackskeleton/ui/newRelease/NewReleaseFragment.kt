package co.basic.androidjetpackskeleton.ui.newRelease

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.basic.androidjetpackskeleton.OnItemClickListener
import co.basic.androidjetpackskeleton.R
import co.basic.androidjetpackskeleton.activities.MovieDetailActivity
import co.basic.androidjetpackskeleton.adapters.PagedMovieAdapter
import co.basic.androidjetpackskeleton.model.Movie

class NewReleaseFragment : Fragment(), OnItemClickListener {


    private lateinit var newReleasedViewModel: NewReleaseViewModel
    private lateinit var newReleaseAdapter: PagedMovieAdapter
    private var rvMovieList: RecyclerView? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        newReleasedViewModel =
            ViewModelProviders.of(this).get(NewReleaseViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_new_release, container, false)

        rvMovieList = root.findViewById(R.id.rvMovieList)

        rvMovieList!!.setHasFixedSize(false)

        rvMovieList!!.layoutManager = GridLayoutManager(context, 2)
        newReleaseAdapter = PagedMovieAdapter(this)
        rvMovieList!!.adapter = newReleaseAdapter

        newReleasedViewModel.newReleaseMovies().observe(viewLifecycleOwner, Observer {

            newReleaseAdapter.submitList(it)
        })


        return root
    }


    override fun <T> onItemClick(position: Int, itemObj: T) {

        val itemData = itemObj as Movie


        activity?.startActivity(
            Intent(activity, MovieDetailActivity::class.java)
                .putExtra("MOVIE_ID", itemData.id)
        )


    }
}


