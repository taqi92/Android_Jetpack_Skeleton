package co.basic.androidjetpackskeleton.room

import androidx.lifecycle.LiveData

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class RoomDbRepository(private val wordDao: FavouriteDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<FavMoviePoster>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: FavMoviePoster) {
        wordDao.insert(word)
    }
}