package co.basic.androidjetpackskeleton.ui.upcoming

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.basic.androidjetpackskeleton.GlobalValues
import co.basic.androidjetpackskeleton.model.ApiResponse
import co.basic.androidjetpackskeleton.networking.ApiClient
import co.basic.androidjetpackskeleton.networking.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingViewModel : ViewModel() {

    //this is the data that we will fetch asynchronously
    private var upcomingMovieList: MutableLiveData<ApiResponse>? = null

    //we will call this method to get the data
    fun getUpcomingMovies(): LiveData<ApiResponse>? {
        //if the list is null
        if (upcomingMovieList == null) {
            upcomingMovieList = MutableLiveData<ApiResponse>()
            //we will load it asynchronously from server in this method
            loadMovies()
        }

        //finally we will return the list
        return upcomingMovieList
    }


    //This method is using Retrofit to get the JSON data from URL
    private fun loadMovies() {


        val api: ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)


        val call: Call<ApiResponse> = api.getUpcoming(GlobalValues.apiKey, 1)
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {


                val movieData = response.body() as ApiResponse

                upcomingMovieList!!.value = movieData
                Log.d("api",upcomingMovieList?.value.toString())
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("api","failure")
                upcomingMovieList!!.value=null
            }
        })
    }
}