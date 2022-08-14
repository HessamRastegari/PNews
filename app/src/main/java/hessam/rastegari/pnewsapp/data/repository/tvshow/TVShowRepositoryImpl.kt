package hessam.rastegari.pnewsapp.data.repository.tvshow

import android.util.Log
import hessam.rastegari.pnewsapp.data.model.tvshow.TVShow
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasource.TVShowCacheDatasource
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasource.TVShowLocalDatasource
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasource.TVShowRemoteDatasource
import hessam.rastegari.pnewsapp.domain.repository.TVShowRepository

class TVShowRepositoryImpl(
    private val tvshowRemoteDatasource: TVShowRemoteDatasource,
    private val tvshowLocalDatasource: TVShowLocalDatasource,
    private val tvshowCacheDatasource: TVShowCacheDatasource,

    ) : TVShowRepository {
    override suspend fun getTVShows(): List<TVShow>? {
        return getTVShowFromCache()
    }

    override suspend fun updateTVShows(): List<TVShow>? {
        val newListOfTVShow = getTVShowFromAPI()
        tvshowLocalDatasource.clearAll()
        tvshowLocalDatasource.saveTVShowToDB(newListOfTVShow)
        tvshowCacheDatasource.saveTVShowToCache(newListOfTVShow)
        return newListOfTVShow
    }

    private suspend fun getTVShowFromAPI(): List<TVShow> {
        lateinit var tvshowList: List<TVShow>

        try {
            val response = tvshowRemoteDatasource.getTVShow()
            val body = response.body()
            if (body != null) {
                tvshowList = body.tvshows
            }
        } catch (e: Exception) {
            Log.i("MYTAG", "error is : ${e.message}")
        }


        return tvshowList
    }

    suspend fun getTVShowFromDB(): List<TVShow> {
        lateinit var tvshowList: List<TVShow>
        try {
            tvshowList = tvshowLocalDatasource.getTVShowFromDB()
        } catch (e: Exception) {
            Log.i("MYTAG", "error is : ${e.message}")
        }
        if (tvshowList.size > 0) {
            return tvshowList
        } else {
            tvshowList = getTVShowFromAPI()
            tvshowLocalDatasource.saveTVShowToDB(tvshowList)
        }
        return tvshowList
    }


    suspend fun getTVShowFromCache(): List<TVShow> {
        lateinit var tvshowList: List<TVShow>
        try {
            tvshowList = tvshowCacheDatasource.getTVShowFromCache()
        } catch (e: Exception) {
            Log.i("MYTAG", "error is : ${e.message}")
        }
        if (tvshowList.isNotEmpty()) {
            return tvshowList
        } else {
            tvshowList = getTVShowFromDB()
            tvshowCacheDatasource.saveTVShowToCache(tvshowList)
        }
        return tvshowList
    }
}