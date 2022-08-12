package hessam.rastegari.pnewsapp.domain.usecase

import hessam.rastegari.pnewsapp.domain.repository.MovieRepository
import hessam.rastegari.pnewsapp.domain.repository.TVShowRepository

class UpdateTVShowsUseCase(private val tvShowRepository: TVShowRepository) {
    suspend fun execute()=tvShowRepository.updateTVShows()
}