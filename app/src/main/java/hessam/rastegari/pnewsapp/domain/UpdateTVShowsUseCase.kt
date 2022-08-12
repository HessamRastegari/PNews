package hessam.rastegari.pnewsapp.domain

class UpdateTVShowsUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute()=movieRepository.updateTVShows()
}