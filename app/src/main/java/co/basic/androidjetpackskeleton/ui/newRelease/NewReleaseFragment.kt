package co.basic.androidjetpackskeleton.ui.newRelease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.basic.androidjetpackskeleton.R
import co.basic.androidjetpackskeleton.adapters.RecyclerViewAdapter

class NewReleaseFragment : Fragment() {

    private lateinit var newReleasedViewModel: NewReleaseViewModel


    private var rvNewReleased: RecyclerView? = null
    private var adapter: RecyclerViewAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        newReleasedViewModel =
            ViewModelProviders.of(this).get(NewReleaseViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_new_release, container, false)


        rvNewReleased = root.findViewById(R.id.rvMovieList)


        rvNewReleased!!.layoutManager = GridLayoutManager(context, 2)


        newReleasedViewModel.getMovies()?.observe(viewLifecycleOwner, {
            it?.let {

                adapter = context?.let { it1 -> RecyclerViewAdapter(it1, it.results) }
                rvNewReleased?.adapter = adapter
            } ?: run { Toast.makeText(context, "Network error!!", Toast.LENGTH_LONG).show() }
        })




        return root
    }
}


