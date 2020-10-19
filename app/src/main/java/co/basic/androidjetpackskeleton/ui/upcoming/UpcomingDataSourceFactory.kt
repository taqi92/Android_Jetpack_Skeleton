package co.basic.androidjetpackskeleton.ui.upcoming

import androidx.lifecycle.MutableLiveData
import co.basic.androidjetpackskeleton.model.Movie

class UpcomingDataSourceFactory : androidx.paging.DataSource.Factory<Int,Movie>() {

    val upcomingMovieLiveData = MutableLiveData<UpcomingItemDataSource>()


    override fun create(): androidx.paging.DataSource<Int, Movie> {

        val upcomingMovieDataSource = UpcomingItemDataSource()

        upcomingMovieLiveData.postValue(upcomingMovieDataSource)
        return upcomingMovieDataSource
    }
}