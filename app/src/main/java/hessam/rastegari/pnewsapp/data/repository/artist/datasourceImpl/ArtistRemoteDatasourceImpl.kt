package hessam.rastegari.pnewsapp.data.repository.artist.datasourceImpl

import hessam.rastegari.pnewsapp.data.api.TMDBService
import hessam.rastegari.pnewsapp.data.model.artist.ArtistList
import hessam.rastegari.pnewsapp.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): ArtistRemoteDatasource {

    override suspend fun getArtist(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}