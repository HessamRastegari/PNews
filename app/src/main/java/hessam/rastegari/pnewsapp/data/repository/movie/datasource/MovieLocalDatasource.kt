package hessam.rastegari.pnewsapp.data.repository.movie.datasource

import hessam.rastegari.pnewsapp.data.model.movie.Movie
import hessam.rastegari.pnewsapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieLocalDatasource {
    suspend fun getMovieFromDB():List<Movie>
    suspend fun saveMovieToDB(movies:List<Movie>)
    suspend fun clearAll()
}