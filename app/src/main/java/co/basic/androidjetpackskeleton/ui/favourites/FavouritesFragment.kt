package co.basic.androidjetpackskeleton.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.basic.androidjetpackskeleton.R

class FavouritesFragment : Fragment() {

    private lateinit var favouritesViewModel: FavouritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_new_release, container, false)

        return root
    }
}