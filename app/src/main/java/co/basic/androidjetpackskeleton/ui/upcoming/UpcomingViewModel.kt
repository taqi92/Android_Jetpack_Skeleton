package co.basic.androidjetpackskeleton.ui.upcoming

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import co.basic.androidjetpackskeleton.model.Movie

class UpcomingViewModel : ViewModel() {

    //this is the data that we will fetch asynchronously
    private var upcomingMovieList: LiveData<UpcomingItemDataSource>? = null

    //we will call this method to get the data
    fun getUpcomingMovies(): LiveData<PagedList<Movie>>? {

        val upcomingDataSourceFactory = UpcomingDataSourceFactory()
        upcomingMovieList = upcomingDataSourceFactory.upcomingMovieLiveData

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(UpcomingItemDataSource.PAGE_SIZE)
            .build()

        return LivePagedListBuilder(upcomingDataSourceFactory, config).build()

    }
}