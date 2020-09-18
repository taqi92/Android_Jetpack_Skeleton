package co.basic.androidjetpackskeleton.activities

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.basic.androidjetpackskeleton.GlobalValues
import co.basic.androidjetpackskeleton.model.MovieDetail
import co.basic.androidjetpackskeleton.networking.ApiClient
import co.basic.androidjetpackskeleton.networking.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailViewModel : ViewModel() {

    private var movieDetail: MutableLiveData<MovieDetail>? = null


    var movie : Int = 0

    fun getMovieDetail(movieId: Int): LiveData<MovieDetail>? {


        this.movie = movieId

        loadData(movieId)

        return movieDetail
    }


    private fun loadData(movieId: Int) {

        val api: ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)

        val call: Call<MovieDetail> = api.getMovieDetail(movieId,GlobalValues.apiKey)
        call.enqueue(object : Callback<MovieDetail> {
            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {


                /*val movieData = response.body() as MovieDetail

                movieDetail!!.value = movieData*/

                if (response.isSuccessful) {

                    val movieData = response.body() as MovieDetail

                    movieDetail?.postValue(movieData)

                    var title:String = movieData.originalTitle

                    Log.d("tag", movieData.originalTitle)
                }


            }

            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                Log.d("api", "failure")

            }
        })


    }


}