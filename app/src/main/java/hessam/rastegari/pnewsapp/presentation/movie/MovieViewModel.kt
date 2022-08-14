package hessam.rastegari.pnewsapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import hessam.rastegari.pnewsapp.domain.usecase.GetMoviesUseCase
import hessam.rastegari.pnewsapp.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getUpdateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }


    fun updateMovies() = liveData {
        val movieList = getUpdateMoviesUseCase.execute()
        emit(movieList)
    }


}