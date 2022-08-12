package hessam.rastegari.pnewsapp.domain.usecase

import hessam.rastegari.pnewsapp.data.model.tvshow.TVShow
import hessam.rastegari.pnewsapp.domain.repository.TVShowRepository

class GetTVShowsUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun execute():List<TVShow>? = tvShowRepository.getTVShows()
}