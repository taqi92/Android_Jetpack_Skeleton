package co.basic.androidjetpackskeleton.ui.topRated

import android.util.Log
import androidx.paging.PageKeyedDataSource
import co.basic.androidjetpackskeleton.GlobalValues
import co.basic.androidjetpackskeleton.model.Movie
import co.basic.androidjetpackskeleton.model.PagedMovieList
import co.basic.androidjetpackskeleton.networking.ApiClient
import co.basic.androidjetpackskeleton.networking.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRatedDataSource : PageKeyedDataSource<Int, Movie>() {


    private val TAG = "topRatedItemDataSource"

    companion object {
        val PAGE_SIZE = 50
        val FIRST_PAGE = 1
    }

    private val api: ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {

        val call: Call<PagedMovieList<Movie>> = api.getTopRated(GlobalValues.apiKey, FIRST_PAGE)
        call.enqueue(object : Callback<PagedMovieList<Movie>> {
            override fun onResponse(call: Call<PagedMovieList<Movie>>, response: Response<PagedMovieList<Movie>>
            ) {
                val pagedMovieListResponse = response.body() as PagedMovieList<Movie>
                pagedMovieListResponse.movieList?.let {
                    callback.onResult(
                        it,
                        null,
                        FIRST_PAGE + 1
                    )
                }
            }

            override fun onFailure(call: Call<PagedMovieList<Movie>>, t: Throwable) {
                Log.d(TAG, "onFailure: loadInitial:  ${t.message}")
            }
        })

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {

        val call: Call <PagedMovieList<Movie>> = api.getTopRated(GlobalValues.apiKey,params.key)
        call.enqueue(object : Callback<PagedMovieList<Movie>> {
            override fun onResponse(
                call: Call<PagedMovieList<Movie>>,
                response: Response<PagedMovieList<Movie>>
            ) {
                val nextPageKey = params.key + 1
                val pagedMovieListResponse = response.body() as PagedMovieList<Movie>
                pagedMovieListResponse.movieList?.let {
                    callback.onResult(it, nextPageKey)
                }
            }

            override fun onFailure(call: Call<PagedMovieList<Movie>>, t: Throwable) {
                Log.d(TAG, "onFailure: loadAfter:  ${t.message}")
            }
        })

    }


}