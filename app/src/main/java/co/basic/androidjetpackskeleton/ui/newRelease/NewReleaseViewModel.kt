package co.basic.androidjetpackskeleton.ui.newRelease

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import co.basic.androidjetpackskeleton.ItemDataSource
import co.basic.androidjetpackskeleton.ItemDataSourceFactory
import co.basic.androidjetpackskeleton.model.ApiResponse
import co.basic.androidjetpackskeleton.model.Movie

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


       /* val api: ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)

        val call: Call<ApiResponse> = api.getNewReleased(GlobalValues.apiKey, 1)
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {


                val movieData = response.body() as ApiResponse
               // movieData?.let { movieList?.postValue(movieData) }

                movieList!!.value = movieData
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("api","failure")
                movieList!!.value=null
            }
        })*/
    }

    fun newReleaseMovies():LiveData<PagedList<Movie>>  {
        val itemDataSourceFactory = ItemDataSourceFactory()
        val liveDataSource = itemDataSourceFactory.dataSourceLiveData

        val config= PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(ItemDataSource.PAGE_SIZE)
            .build()

       return LivePagedListBuilder(itemDataSourceFactory, config).build()

    }

}