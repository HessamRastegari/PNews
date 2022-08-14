package hessam.rastegari.pnewsapp.data.repository.artist.datasource

import hessam.rastegari.pnewsapp.data.model.artist.Artist

interface ArtistCacheDatasource {
    suspend fun getArtistFromCache():List<Artist>
    suspend fun saveArtistToCache(artists: List<Artist>)
}