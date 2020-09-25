package co.basic.androidjetpackskeleton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import co.basic.androidjetpackskeleton.model.Data;

public class ItemViewModel extends ViewModel {

    LiveData itemPagedList;
    LiveData<PageKeyedDataSource<Integer, Data>> liveDataSource;

    public ItemViewModel() {

        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(50)
                        .build();

        itemPagedList = (new LivePagedListBuilder<>(itemDataSourceFactory, config)).build();

    }
}
