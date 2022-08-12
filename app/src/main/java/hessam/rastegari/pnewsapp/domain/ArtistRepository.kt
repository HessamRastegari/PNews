package hessam.rastegari.pnewsapp.domain

import hessam.rastegari.pnewsapp.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist():List<Artist>?
    suspend fun updateArtist():List<Artist>?
}