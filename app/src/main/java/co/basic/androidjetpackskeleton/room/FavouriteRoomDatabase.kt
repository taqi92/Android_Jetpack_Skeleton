package co.basic.androidjetpackskeleton.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(FavMoviePoster::class), version = 1, exportSchema = false)
abstract class FavouriteRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): FavouriteDao

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var wordDao = database.wordDao()

                    // Delete all content here.
                    wordDao.deleteAll()

                    // Add sample words.
                    /*var word = FavMoviePoster("Hello")
                    wordDao.insert(word)
                    word = FavMoviePoster("World!")
                    wordDao.insert(word)

                    // TODO: Add your own words!
                    word = FavMoviePoster("TODO!")
                    wordDao.insert(word)
                    word = FavMoviePoster("Taqi!")
                    wordDao.insert(word)*/

                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: FavouriteRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): FavouriteRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavouriteRoomDatabase::class.java,
                    "word_database"
                )
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}