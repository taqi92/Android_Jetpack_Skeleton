package co.basic.androidjetpackskeleton.ui.topRated

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

class TopRatedViewModel : ViewModel() {

    private var topMovieList: MutableLiveData<ApiResponse>? = null

    fun getTopMovies(): LiveData<ApiResponse>? {

        if (topMovieList == null) {

            topMovieList = MutableLiveData<ApiResponse>()
            loadData()
        }

        return topMovieList
    }

    private fun loadData() {

        val api: ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)

        val call: Call<ApiResponse> = api.getTopRated(GlobalValues.apiKey, 1)
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {


                val topMovieData = response.body() as ApiResponse


                topMovieList!!.value = topMovieData
                Log.d("api", topMovieList?.value.toString())
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("api", "failure")
                topMovieList!!.value = null
            }
        })
    }


}