package hessam.rastegari.pnewsapp.domain.repository

import hessam.rastegari.pnewsapp.data.model.tvshow.TVShow

interface TVShowRepository {
    suspend fun getTVShows():List<TVShow>?
    suspend fun updateTVShows():List<TVShow>?
}