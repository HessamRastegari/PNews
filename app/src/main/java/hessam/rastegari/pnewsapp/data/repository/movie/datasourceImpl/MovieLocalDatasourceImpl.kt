package hessam.rastegari.pnewsapp.data.repository.movie.datasourceImpl

import hessam.rastegari.pnewsapp.data.db.MovieDAO
import hessam.rastegari.pnewsapp.data.model.movie.Movie
import hessam.rastegari.pnewsapp.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceImpl(private val movieDao: MovieDAO): MovieLocalDatasource {
    override suspend fun getMovieFromDB(): List<Movie> = movieDao.getMovies()


    override suspend fun saveMovieToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}