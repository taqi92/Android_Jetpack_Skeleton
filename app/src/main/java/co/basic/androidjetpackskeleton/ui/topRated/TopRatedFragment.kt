package co.basic.androidjetpackskeleton.ui.topRated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.basic.androidjetpackskeleton.R
import co.basic.androidjetpackskeleton.adapters.RecyclerViewAdapter

class TopRatedFragment : Fragment() {

    private lateinit var topRatedViewModel: TopRatedViewModel

    private var rvTopMovies: RecyclerView? = null
    private var adapter: RecyclerViewAdapter? = null


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

        topRatedViewModel.getTopMovies()?.observe(viewLifecycleOwner, {

            it?.let {

                adapter = context?.let { it1 -> RecyclerViewAdapter(it1, it.results) }
                rvTopMovies?.adapter = adapter
            }?.run { Toast.makeText(context, "Network Error!!", Toast.LENGTH_SHORT).show() }

        })


        return root
    }
}