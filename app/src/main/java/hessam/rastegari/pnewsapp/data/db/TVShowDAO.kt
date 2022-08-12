package hessam.rastegari.pnewsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hessam.rastegari.pnewsapp.data.model.tvshow.TVShow

@Dao
interface TVShowDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvShow: List<TVShow>)

    @Query("DELETE FROM popular_tvshow")
    suspend fun deleteAllTVShows()

    @Query("SELECT * FROM popular_tvshow")
    suspend fun getTVShows(tvShows: List<TVShow>)
}