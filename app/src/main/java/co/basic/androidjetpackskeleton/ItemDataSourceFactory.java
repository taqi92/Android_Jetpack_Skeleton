package co.basic.androidjetpackskeleton;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import co.basic.androidjetpackskeleton.model.Data;
import co.basic.androidjetpackskeleton.model.MovieDetail;
import co.basic.androidjetpackskeleton.model.PagedMovieList;

public class ItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, MovieDetail>> itemLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource create() {
        ItemDataSource itemDataSource = new ItemDataSource();
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    /*public MutableLiveData<PageKeyedDataSource<Integer, Data>> getItemLiveDataSource() {
     //   return itemLiveDataSource;
    }*/
}
