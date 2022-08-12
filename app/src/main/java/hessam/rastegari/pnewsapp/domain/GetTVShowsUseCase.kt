package hessam.rastegari.pnewsapp.domain

import hessam.rastegari.pnewsapp.data.model.tvshow.TVShow

class GetTVShowsUseCase(private val movieRepository: TVShowRepository) {

    suspend fun execute():List<TVShow>? = movieRepository.getTVShows()
}