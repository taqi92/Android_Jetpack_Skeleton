package co.basic.androidjetpackskeleton.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import co.basic.androidjetpackskeleton.R
import co.basic.androidjetpackskeleton.room.FavMoviePoster
import co.basic.androidjetpackskeleton.ui.favourites.FaavouritesViewModel
import co.basic.androidjetpackskeleton.networking.ApiClient
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*


class MovieDetailActivity : AppCompatActivity() {

    lateinit var movieDetailViewModel: MovieDetailViewModel

    lateinit var faavouritesViewModel: FaavouritesViewModel

    private lateinit var image: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)


        movieDetailViewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)

        val number = intent.getIntExtra("MOVIE_ID", 1)


        faavouritesViewModel = ViewModelProvider(this).get(FaavouritesViewModel::class.java)
        faavouritesViewModel.allWords.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            //words?.let { adapter.setWords(it) }
        })


        movieDetailViewModel.getMovieDetail(number)?.observe(this, {

            it.let {

                for (i in 0 until it.productionCountries.size) tvProductionCountries.text =
                    it.productionCountries[i].name.plus("\n")

                for (i in 0 until it.productionCompanies.size) tvProductionCompany.text =
                    it.productionCompanies[i].name

                for (i in 0 until it.spokenLanguages.size) tvLanguage.text =
                    it.spokenLanguages[i].name

                for (i in 0 until it.genres.size) tvGenre.text = it.genres[i].name


                tvMovieTitle.text = it.originalTitle
                tvVoteAvg.text = it.voteAverage.toString()
                tvPopularity.text =
                    ((it.popularity / it.voteCount) * 100).toString().substring(0, 2).plus(
                        "%"
                    )
                tvReleaseDate.text = ("(") + it.releaseDate + (")")
                tvOverview.text = it.overview
                tvBudget.text = it.budget.toString()

                image = ApiClient.IMAGE_URL + it.posterPath

                Picasso.get().load(ApiClient.IMAGE_URL + it.backDropPath)
                    .into(ivPosterPath)

                tvFavourite.setOnClickListener {
                    val word = FavMoviePoster(image)
                    faavouritesViewModel.insert(word)

                    Toast.makeText(this, "Added to favourite list!", Toast.LENGTH_SHORT).show()
                }
            }


        })


    }
}