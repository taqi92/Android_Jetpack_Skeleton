package co.basic.androidjetpackskeleton.ui.favourites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import co.basic.androidjetpackskeleton.room.FavMoviePoster
import co.basic.androidjetpackskeleton.room.FavouriteRoomDatabase
import co.basic.androidjetpackskeleton.room.RoomDbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FaavouritesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: RoomDbRepository

    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allWords: LiveData<List<FavMoviePoster>>

    init {
        val wordsDao = FavouriteRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = RoomDbRepository(wordsDao)
        allWords = repository.allWords

    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(word: FavMoviePoster) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }
}