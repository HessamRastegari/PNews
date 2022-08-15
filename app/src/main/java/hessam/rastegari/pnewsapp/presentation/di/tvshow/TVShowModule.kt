package hessam.rastegari.pnewsapp.presentation.di.tvshow

import dagger.Module
import dagger.Provides
import hessam.rastegari.pnewsapp.domain.usecase.GetArtistUseCase
import hessam.rastegari.pnewsapp.domain.usecase.GetTVShowsUseCase
import hessam.rastegari.pnewsapp.domain.usecase.UpdateArtistUseCase
import hessam.rastegari.pnewsapp.domain.usecase.UpdateTVShowsUseCase
import hessam.rastegari.pnewsapp.presentation.artist.ArtistViewModelFactory
import hessam.rastegari.pnewsapp.presentation.tvshow.TVShowsViewModelFactory

@Module
class TVShowModule {

    @TVShowScope
    @Provides
    fun provideTVShowViewmodelFactory(
        getTVShowUseCase: GetTVShowsUseCase,
        updateTVShowUseCase: UpdateTVShowsUseCase
    ): TVShowsViewModelFactory {
        return TVShowsViewModelFactory(
            getTVShowUseCase,
            updateTVShowUseCase
        )
    }
}