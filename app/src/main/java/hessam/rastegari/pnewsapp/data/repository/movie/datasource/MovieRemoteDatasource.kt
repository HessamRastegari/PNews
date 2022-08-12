package hessam.rastegari.pnewsapp.data.repository.movie.datasource

import hessam.rastegari.pnewsapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}