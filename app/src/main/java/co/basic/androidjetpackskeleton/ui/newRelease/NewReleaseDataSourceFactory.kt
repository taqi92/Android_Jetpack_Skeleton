package co.basic.androidjetpackskeleton.ui.newRelease

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import co.basic.androidjetpackskeleton.model.Movie

class NewReleaseDataSourceFactory :
    DataSource.Factory<Int, Movie>() {

    val dataSourceLiveData = MutableLiveData<NewReleaseDataSource>()

    override fun create(): DataSource<Int, Movie> {

        val itemDataSource = NewReleaseDataSource()
        dataSourceLiveData.postValue(itemDataSource)
        return itemDataSource
    }
}