package co.basic.androidjetpackskeleton.ui.newRelease

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.basic.androidjetpackskeleton.GlobalValues
import co.basic.androidjetpackskeleton.model.ApiResponse
import co.basic.androidjetpackskeleton.model.Data
import co.basic.androidjetpackskeleton.networking.ApiClient
import co.basic.androidjetpackskeleton.networking.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class NewReleaseViewModel : ViewModel() {


    //this is the data that we will fetch asynchronously
    private var movieList: MutableLiveData<ApiResponse>? = null

    //we will call this method to get the data
    fun getMovies(): LiveData<ApiResponse>? {
        //if the list is null
        if (movieList == null) {
            movieList = MutableLiveData<ApiResponse>()
            //we will load it asynchronously from server in this method
            loadMovies()
        }

        //finally we will return the list
        return movieList
    }


    //This method is using Retrofit to get the JSON data from URL
     fun loadMovies() {


        val api: ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)


        val call: Call<ApiResponse> = api.getNewReleased(GlobalValues.apiKey, 1)
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {


                val movieData = response.body() as ApiResponse
               // movieData?.let { movieList?.postValue(movieData) }

                movieList!!.value = movieData
                Log.d("api",movieList?.value.toString())
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("api","failure")
                movieList!!.value=null
            }
        })
    }

}