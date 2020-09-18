package co.basic.androidjetpackskeleton.ui.upcoming

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
import co.basic.androidjetpackskeleton.model.Data
import co.basic.androidjetpackskeleton.ui.newRelease.OnItemClickListener
import java.util.ArrayList

class UpcomingFragment : Fragment(),RecyclerViewAdapter.ClickListener,OnItemClickListener {

    private lateinit var upcomingViewModel: UpcomingViewModel

    private var rvUpcoming: RecyclerView? = null
    private var adapter: RecyclerViewAdapter? = null

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


        upcomingViewModel.getUpcomingMovies()?.observe(viewLifecycleOwner, {
            it?.let {

                adapter = context?.let { it1 -> RecyclerViewAdapter(it1, it.results,this) }
                rvUpcoming?.adapter = adapter
            } ?: run { Toast.makeText(context, "Network error!!", Toast.LENGTH_LONG).show() }
        })


        return root
    }

    override fun onClickListener(item: ArrayList<Data>) {
        Toast.makeText(context, "worked in updated!", Toast.LENGTH_SHORT).show()
    }

    override fun <T> onItemClick(position: Int, data: T) {
        //TODO("Not yet implemented")
    }
}