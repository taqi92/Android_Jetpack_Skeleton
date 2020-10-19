package co.basic.androidjetpackskeleton.ui.topRated

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import co.basic.androidjetpackskeleton.model.Movie


class TopRatedDataSourceFactory : DataSource.Factory<Int,Movie>() {

    val topRatedDataSourceliveData =  MutableLiveData<TopRatedDataSource>()

    override fun create(): DataSource<Int, Movie> {

        val topRatedItemDataSource = TopRatedDataSource()
        topRatedDataSourceliveData.postValue(topRatedItemDataSource)
        return topRatedItemDataSource

    }
}