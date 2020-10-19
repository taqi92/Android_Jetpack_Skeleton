package co.basic.androidjetpackskeleton.ui.newRelease

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import co.basic.androidjetpackskeleton.model.Movie

class NewReleaseViewModel : ViewModel() {


    private lateinit var liveDataSource: LiveData<NewReleaseDataSource>

    fun newReleaseMovies(): LiveData<PagedList<Movie>> {
        val itemDataSourceFactory = NewReleaseDataSourceFactory()
        liveDataSource = itemDataSourceFactory.dataSourceLiveData

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(NewReleaseDataSource.PAGE_SIZE)
            .build()

        return LivePagedListBuilder(itemDataSourceFactory, config).build()

    }

}