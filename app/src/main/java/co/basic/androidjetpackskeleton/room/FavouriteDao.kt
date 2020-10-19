package co.basic.androidjetpackskeleton.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavouriteDao {

    @Query("SELECT * from favourite_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<FavMoviePoster>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: FavMoviePoster)

    @Query("DELETE FROM favourite_table")
    suspend fun deleteAll()
}