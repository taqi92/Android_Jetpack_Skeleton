package co.basic.androidjetpackskeleton.activities

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.basic.androidjetpackskeleton.GlobalValues
import co.basic.androidjetpackskeleton.model.Movie
import co.basic.androidjetpackskeleton.networking.ApiClient
import co.basic.androidjetpackskeleton.networking.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailViewModel : ViewModel() {

    var movieDetail: MutableLiveData<Movie>? = null


    var movie: Int = 0

    fun getMovieDetail(movieId: Int): LiveData<Movie>? {


        this.movie = movieId

        if (movieDetail == null) {

            movieDetail = MutableLiveData<Movie>()
            loadData(movieId)
        }


        return movieDetail
    }


    private fun loadData(movieId: Int) {

        val api: ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)

        val call: Call<Movie> = api.getMovieDetail(movieId, GlobalValues.apiKey)
        call.enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {

                if (response.isSuccessful) {

                    val movieData = response.body() as Movie

                    movieDetail?.postValue(movieData)

                }


            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.d("api", "failure")

            }
        })


    }


}