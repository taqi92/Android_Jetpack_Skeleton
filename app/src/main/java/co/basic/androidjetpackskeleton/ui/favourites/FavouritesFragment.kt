package co.basic.androidjetpackskeleton.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.basic.androidjetpackskeleton.R
import co.basic.androidjetpackskeleton.adapters.FavouriteListAdapter

class FavouritesFragment : Fragment() {

    private lateinit var faavouritesViewModel: FaavouritesViewModel
    var recyclerView: RecyclerView? = null
    var adapter: FavouriteListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_favourites, container, false)

        recyclerView = root.findViewById(R.id.recyclerview)
        adapter = context?.let { FavouriteListAdapter(it) }
        recyclerView!!.adapter = adapter
        recyclerView!!.layoutManager = GridLayoutManager(context,2)


        faavouritesViewModel = ViewModelProvider(this).get(FaavouritesViewModel::class.java)
        faavouritesViewModel.allWords.observe(viewLifecycleOwner, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter!!.setWords(it) }
        })

        return root
    }
}