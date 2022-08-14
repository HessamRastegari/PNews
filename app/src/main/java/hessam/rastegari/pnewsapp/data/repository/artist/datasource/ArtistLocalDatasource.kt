package hessam.rastegari.pnewsapp.data.repository.artist.datasource

import hessam.rastegari.pnewsapp.data.model.artist.Artist
import hessam.rastegari.pnewsapp.data.model.movie.Movie
import hessam.rastegari.pnewsapp.data.model.movie.MovieList
import retrofit2.Response

interface ArtistLocalDatasource {
    suspend fun getArtistFromDB():List<Artist>
    suspend fun saveArtistToDB(movies:List<Artist>)
    suspend fun clearAll()
}