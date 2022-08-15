package hessam.rastegari.pnewsapp.presentation.di.artist

import dagger.Module
import dagger.Provides
import hessam.rastegari.pnewsapp.domain.usecase.GetArtistUseCase
import hessam.rastegari.pnewsapp.domain.usecase.UpdateArtistUseCase
import hessam.rastegari.pnewsapp.presentation.artist.ArtistViewModelFactory

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewmodelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(
            getArtistUseCase,
            updateArtistUseCase
        )
    }
}