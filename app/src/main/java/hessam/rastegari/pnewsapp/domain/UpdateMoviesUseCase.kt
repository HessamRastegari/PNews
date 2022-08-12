package hessam.rastegari.pnewsapp.domain

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute() = movieRepository.updateMovies()
}