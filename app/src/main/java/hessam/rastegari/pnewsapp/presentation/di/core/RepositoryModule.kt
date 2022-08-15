package hessam.rastegari.pnewsapp.presentation.di.core

import dagger.Module
import dagger.Provides
import hessam.rastegari.pnewsapp.data.repository.artist.ArtistRepositoryImpl
import hessam.rastegari.pnewsapp.data.repository.artist.datasource.ArtistCacheDatasource
import hessam.rastegari.pnewsapp.data.repository.artist.datasource.ArtistLocalDatasource
import hessam.rastegari.pnewsapp.data.repository.artist.datasource.ArtistRemoteDatasource
import hessam.rastegari.pnewsapp.data.repository.movie.MovieRepositoryImpl
import hessam.rastegari.pnewsapp.data.repository.movie.datasource.MovieCacheDatasource
import hessam.rastegari.pnewsapp.data.repository.movie.datasource.MovieLocalDatasource
import hessam.rastegari.pnewsapp.data.repository.movie.datasource.MovieRemoteDatasource
import hessam.rastegari.pnewsapp.data.repository.tvshow.TVShowRepositoryImpl
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasource.TVShowCacheDatasource
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasource.TVShowLocalDatasource
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasource.TVShowRemoteDatasource
import hessam.rastegari.pnewsapp.domain.repository.ArtistRepository
import hessam.rastegari.pnewsapp.domain.repository.MovieRepository
import hessam.rastegari.pnewsapp.domain.repository.TVShowRepository
import javax.inject.Singleton

@Module
class RepositoryModule {


    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepository{

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDatasource,
            movieCacheDatasource
        )
    }


    @Singleton
    @Provides
    fun provideTVShowRepository(
        tvShowRemoteDatasource: TVShowRemoteDatasource,
        tvShowLocalDatasource: TVShowLocalDatasource,
        tvShowCacheDatasource: TVShowCacheDatasource
    ): TVShowRepository {

        return TVShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDatasource,
            tvShowCacheDatasource
        )
    }



    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDatasource: ArtistLocalDatasource,
        artistCacheDatasource: ArtistCacheDatasource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDatasource,
            artistCacheDatasource
        )
    }
}