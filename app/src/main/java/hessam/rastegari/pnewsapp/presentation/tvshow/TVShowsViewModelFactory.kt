package hessam.rastegari.pnewsapp.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hessam.rastegari.pnewsapp.domain.usecase.GetTVShowsUseCase
import hessam.rastegari.pnewsapp.domain.usecase.UpdateTVShowsUseCase

class TVShowsViewModelFactory(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TVShowViewModel(getTVShowsUseCase,updateTVShowsUseCase) as T
    }
}