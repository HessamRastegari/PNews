package hessam.rastegari.pnewsapp.domain.usecase

import hessam.rastegari.pnewsapp.data.model.artist.Artist
import hessam.rastegari.pnewsapp.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtist()
}