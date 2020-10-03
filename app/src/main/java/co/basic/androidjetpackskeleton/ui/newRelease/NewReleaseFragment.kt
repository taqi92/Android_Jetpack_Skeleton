package co.basic.androidjetpackskeleton.ui.newRelease

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
import co.basic.androidjetpackskeleton.adapters.PagedMovieAdapter
import co.basic.androidjetpackskeleton.adapters.RecyclerViewAdapter
import co.basic.androidjetpackskeleton.model.Data
import kotlinx.android.synthetic.main.fragment_new_release.*

class NewReleaseFragment : Fragment(), OnItemClickListener {


    private lateinit var newReleasedViewModel: NewReleaseViewModel
    private lateinit var adapter: PagedMovieAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        newReleasedViewModel =
            ViewModelProviders.of(this).get(NewReleaseViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_new_release, container, false)

        rvMovieList!!.layoutManager = GridLayoutManager(context, 2)
        adapter = PagedMovieAdapter(this)
        rvMovieList.adapter = adapter

        newReleasedViewModel.newReleaseMovies().observe(viewLifecycleOwner, Observer {

            adapter.submitList(it)
        })


        return root
    }


    override fun <T> onItemClick(position: Int, itemObj: T) {

        val itemData = itemObj as Data
        //Toast.makeText(context, "kam hoise! "+ itemData.id+" "+position, Toast.LENGTH_LONG).show()


        activity?.startActivity(
            Intent(activity, MovieDetailActivity::class.java)
                .putExtra("MOVIE_ID", itemData.id)
        )


    }
}


