package hessam.rastegari.pnewsapp.domain


class UpdateArtistUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute() = movieRepository.updateArtist()
}