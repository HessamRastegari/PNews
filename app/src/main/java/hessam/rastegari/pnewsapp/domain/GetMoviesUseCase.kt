package hessam.rastegari.pnewsapp.domain

import hessam.rastegari.pnewsapp.data.model.movie.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}