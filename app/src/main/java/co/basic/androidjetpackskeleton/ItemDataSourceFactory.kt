package co.basic.androidjetpackskeleton

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import co.basic.androidjetpackskeleton.model.Movie

class ItemDataSourceFactory :
    DataSource.Factory<Int, Movie>() {

    val dataSourceLiveData = MutableLiveData<ItemDataSource>()

    override fun create(): DataSource<Int, Movie> {

        val itemDataSource = ItemDataSource()
        dataSourceLiveData.postValue(itemDataSource)
        return itemDataSource
    }
}