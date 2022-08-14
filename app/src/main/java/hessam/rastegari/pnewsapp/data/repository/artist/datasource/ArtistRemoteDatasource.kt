package hessam.rastegari.pnewsapp.data.repository.artist.datasource

import hessam.rastegari.pnewsapp.data.model.artist.ArtistList
import hessam.rastegari.pnewsapp.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtist(): Response<ArtistList>
}