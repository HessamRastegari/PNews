package hessam.rastegari.pnewsapp.data.repository.tvshow.datasourceImpl

import hessam.rastegari.pnewsapp.data.db.TVShowDAO
import hessam.rastegari.pnewsapp.data.model.tvshow.TVShow
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasource.TVShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDatasourceImpl(private val tvshowDAO: TVShowDAO): TVShowLocalDatasource {
    override suspend fun getTVShowFromDB(): List<TVShow> = tvshowDAO.getTVShows()


    override suspend fun saveTVShowToDB(tvshows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDAO.saveTVShows(tvshows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDAO.deleteAllTVShows()
        }
    }
}