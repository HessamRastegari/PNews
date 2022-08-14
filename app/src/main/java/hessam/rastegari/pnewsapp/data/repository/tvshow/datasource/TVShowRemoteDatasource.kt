package hessam.rastegari.pnewsapp.data.repository.tvshow.datasource

import hessam.rastegari.pnewsapp.data.model.tvshow.TVShowList
import retrofit2.Response

interface TVShowRemoteDatasource {
    suspend fun getTVShow(): Response<TVShowList>
}