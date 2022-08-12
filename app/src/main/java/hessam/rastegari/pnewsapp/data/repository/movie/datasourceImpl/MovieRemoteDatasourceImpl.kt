package hessam.rastegari.pnewsapp.data.repository.movie.datasourceImpl

import hessam.rastegari.pnewsapp.data.api.TMDBService
import hessam.rastegari.pnewsapp.data.model.movie.MovieList
import hessam.rastegari.pnewsapp.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): MovieRemoteDatasource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}