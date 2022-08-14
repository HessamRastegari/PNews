package hessam.rastegari.pnewsapp.data.repository.tvshow.datasourceImpl

import hessam.rastegari.pnewsapp.data.model.tvshow.TVShow
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasource.TVShowCacheDatasource

class TVShowCacheDatasourceImpl : TVShowCacheDatasource {

    private var tvshowList = ArrayList<TVShow>()
    override suspend fun getTVShowFromCache(): List<TVShow> {
        return tvshowList
    }

    override suspend fun saveTVShowToCache(artists: List<TVShow>) {
        tvshowList.clear()
        tvshowList = ArrayList(artists)
    }
}