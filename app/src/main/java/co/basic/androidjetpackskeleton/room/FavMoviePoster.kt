package co.basic.androidjetpackskeleton.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favourite_table")
class FavMoviePoster(@PrimaryKey @ColumnInfo(name = "word") val word: String)

