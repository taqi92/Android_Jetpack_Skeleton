package co.basic.androidjetpackskeleton

import androidx.paging.PageKeyedDataSource
import co.basic.androidjetpackskeleton.model.Data
import co.basic.androidjetpackskeleton.model.MovieDetail
import co.basic.androidjetpackskeleton.model.PagedMovieList
import co.basic.androidjetpackskeleton.networking.ApiClient
import co.basic.androidjetpackskeleton.networking.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemDataSource : PageKeyedDataSource<Int?, MovieDetail>() {

    val PAGE_SIZE = 50
    val FIRST_PAGE = 1



    private val api: ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)


    override fun loadInitial(
        params: LoadInitialParams<Int?>,
        callback: LoadInitialCallback<Int?, MovieDetail?>
    ) {

        val call: Call<PagedMovieList<MovieDetail>> = api.getNewReleased(GlobalValues.apiKey, FIRST_PAGE)
        call.enqueue(object : Callback<PagedMovieList<MovieDetail>> {
            override fun onResponse(call: Call<PagedMovieList<MovieDetail>>, response: Response<PagedMovieList<MovieDetail>>) {

               // response.body()?.results?.let { callback.onResult(it, null, FIRST_PAGE + 1) }

                //callback.onResult(response.body()?.movieList,FIRST_PAGE + 1)
            }

            override fun onFailure(call: Call<PagedMovieList<MovieDetail>>, t: Throwable) {

            }
        })
    }

    override fun loadBefore(params: LoadParams<Int?>, callback: LoadCallback<Int?, MovieDetail>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Int?>, callback: LoadCallback<Int?, MovieDetail?>) {
        val call: Call<PagedMovieList<MovieDetail>> = api.getNewReleased(GlobalValues.apiKey,params.key)
        call.enqueue(object : Callback<PagedMovieList<MovieDetail>> {
            override fun onResponse(call: Call<PagedMovieList<MovieDetail>>, response: Response<PagedMovieList<MovieDetail>>) {

             //   val key = if (response.body()?.isHasMore!!) params.key + 1 else null

                val key = params.key+1
                //callback.onResult(response.body()?.movieList,key)

            }

            override fun onFailure(call: Call<PagedMovieList<MovieDetail>>, t: Throwable) {

            }
        })
    }
}