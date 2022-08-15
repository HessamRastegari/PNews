package hessam.rastegari.pnewsapp.presentation.di.movie

import dagger.Module
import dagger.Provides
import hessam.rastegari.pnewsapp.domain.usecase.GetArtistUseCase
import hessam.rastegari.pnewsapp.domain.usecase.GetMoviesUseCase
import hessam.rastegari.pnewsapp.domain.usecase.UpdateArtistUseCase
import hessam.rastegari.pnewsapp.domain.usecase.UpdateMoviesUseCase
import hessam.rastegari.pnewsapp.presentation.artist.ArtistViewModelFactory
import hessam.rastegari.pnewsapp.presentation.movie.MovieViewModelFactory

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewmodelFactory(
        getMovieUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMoviesUseCase
    ):MovieViewModelFactory{
        return MovieViewModelFactory(
            getMovieUseCase,
            updateMovieUseCase
        )
    }
}