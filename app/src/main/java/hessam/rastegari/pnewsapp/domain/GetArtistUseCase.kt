package hessam.rastegari.pnewsapp.domain

import hessam.rastegari.pnewsapp.data.model.artist.Artist

class GetArtistUseCase(private val movieRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = movieRepository.getArtist()
}