package co.basic.androidjetpackskeleton.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.navArgs
import co.basic.androidjetpackskeleton.R

class MovieDetailActivity : AppCompatActivity() {

    lateinit var movieDetailViewModel: MovieDetailViewModel

    val args: MovieDetailActivityArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        movieDetailViewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)

        val number = args.movieId

        Log.d("movieId", number.toString())

        /*movieDetailViewModel.getMovieDetail()?.observe(viewLifecycleOwner(),{

            it?.let{

                val budget = it.originalTitle
                Log.d("tag", budget.toString())
            }
        })*/


        movieDetailViewModel.getMovieDetail()?.observe(this, {

            it.let {

                var budget: String = it.originalTitle
                Log.d("tag", budget)
            }

        })


    }
}