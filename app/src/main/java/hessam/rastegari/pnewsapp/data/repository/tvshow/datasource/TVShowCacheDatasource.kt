package hessam.rastegari.pnewsapp.data.repository.tvshow.datasource

import hessam.rastegari.pnewsapp.data.model.tvshow.TVShow


interface TVShowCacheDatasource {
    suspend fun getTVShowFromCache():List<TVShow>
    suspend fun saveTVShowToCache(tvShows: List<TVShow>)
}