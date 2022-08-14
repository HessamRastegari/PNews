package hessam.rastegari.pnewsapp.data.repository.tvshow.datasource

import hessam.rastegari.pnewsapp.data.model.tvshow.TVShow

interface TVShowLocalDatasource {
    suspend fun getTVShowFromDB():List<TVShow>
    suspend fun saveTVShowToDB(tvshows:List<TVShow>)
    suspend fun clearAll()
}