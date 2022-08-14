package hessam.rastegari.pnewsapp.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import hessam.rastegari.pnewsapp.domain.usecase.GetTVShowsUseCase
import hessam.rastegari.pnewsapp.domain.usecase.UpdateArtistUseCase
import hessam.rastegari.pnewsapp.domain.usecase.UpdateTVShowsUseCase

class TVShowViewModel(
    private val getTVShowUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModel(){

    fun getTVShows() = liveData {
        val tvshowList = getTVShowUseCase.execute()
        emit(tvshowList)
    }

    fun updateTVShows() = liveData {
        val updateTVShowList = updateTVShowsUseCase.execute()
        emit(updateTVShowList)
    }
}