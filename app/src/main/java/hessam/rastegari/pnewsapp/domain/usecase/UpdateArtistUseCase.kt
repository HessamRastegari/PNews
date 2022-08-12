package hessam.rastegari.pnewsapp.domain.usecase

import hessam.rastegari.pnewsapp.domain.repository.ArtistRepository
import hessam.rastegari.pnewsapp.domain.repository.MovieRepository


class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute() = artistRepository.updateArtist()
}