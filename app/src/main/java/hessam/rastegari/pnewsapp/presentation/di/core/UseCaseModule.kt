package hessam.rastegari.pnewsapp.presentation.di.core

import dagger.Module
import dagger.Provides
import hessam.rastegari.pnewsapp.domain.repository.ArtistRepository
import hessam.rastegari.pnewsapp.domain.repository.MovieRepository
import hessam.rastegari.pnewsapp.domain.repository.TVShowRepository
import hessam.rastegari.pnewsapp.domain.usecase.*

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTVShowUseCase(tvShowRepository: TVShowRepository):GetTVShowsUseCase{
        return GetTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTVShowUseCase(tvShowRepository: TVShowRepository):UpdateTVShowsUseCase{
        return UpdateTVShowsUseCase(tvShowRepository)
    }


    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }
}