package hessam.rastegari.pnewsapp.domain.usecase

import hessam.rastegari.pnewsapp.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute() = movieRepository.updateMovies()
}