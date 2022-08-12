package hessam.rastegari.pnewsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import hessam.rastegari.pnewsapp.data.model.artist.Artist
import hessam.rastegari.pnewsapp.data.model.movie.Movie
import hessam.rastegari.pnewsapp.data.model.tvshow.TVShow

@Database(
    entities = [Artist::class, Movie::class, TVShow::class],
    version = 1,
    exportSchema = false
)
abstract class PNewsDatabase : RoomDatabase() {


    abstract fun movieDao(): MovieDAO
    abstract fun TVShowDAO(): TVShowDAO
    abstract fun ArtistDAO(): ArtistDAO
}