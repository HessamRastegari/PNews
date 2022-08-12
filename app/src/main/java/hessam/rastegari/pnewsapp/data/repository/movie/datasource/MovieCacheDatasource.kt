package hessam.rastegari.pnewsapp.data.repository.movie.datasource

import hessam.rastegari.pnewsapp.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}