package hessam.rastegari.pnewsapp.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import hessam.rastegari.pnewsapp.domain.usecase.GetArtistUseCase
import hessam.rastegari.pnewsapp.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModel() {

    fun getArtist() = liveData {
        val artistList =getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtist() = liveData {
        val updateArtist = updateArtistUseCase.execute()
        emit(updateArtist)
    }
}