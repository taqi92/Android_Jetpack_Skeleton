package co.basic.androidjetpackskeleton.ui.newRelease

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.basic.androidjetpackskeleton.R
import co.basic.androidjetpackskeleton.adapters.RecyclerViewAdapter
import co.basic.androidjetpackskeleton.model.ApiResponse
import co.basic.androidjetpackskeleton.model.Data
import java.util.*

class NewReleaseFragment : Fragment() {

    private lateinit var dashboardViewModel: NewReleaseViewModel


    var recyclerView: RecyclerView? = null
    var adapter: RecyclerViewAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        dashboardViewModel =
            ViewModelProviders.of(this).get(NewReleaseViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_new_release, container, false)



        recyclerView = root.findViewById(R.id.rvMovieList)
        //recyclerView!!.setHasFixedSize(true)
        //recyclerView!!.layoutManager = LinearLayoutManager(context,
          //  LinearLayoutManager.VERTICAL,false)

        recyclerView!!.layoutManager = GridLayoutManager(context,2)


        dashboardViewModel.getMovies()?.observe(viewLifecycleOwner,{
            it?.let {

                adapter = RecyclerViewAdapter(context,it.results)
                recyclerView?.adapter = adapter
            }?: run { Toast.makeText(context,"Netwrok error!!",Toast.LENGTH_LONG).show() }
        })




        return root
    }
}


