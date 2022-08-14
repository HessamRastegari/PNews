package hessam.rastegari.pnewsapp.data.repository.tvshow.datasourceImpl

import hessam.rastegari.pnewsapp.data.api.TMDBService
import hessam.rastegari.pnewsapp.data.model.tvshow.TVShowList
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasource.TVShowRemoteDatasource
import retrofit2.Response

class TVShowRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): TVShowRemoteDatasource {

    override suspend fun getTVShow(): Response<TVShowList> = tmdbService.getPopularTVShows(apiKey)

}