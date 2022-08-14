package hessam.rastegari.pnewsapp.presentation.di

import dagger.Module
import dagger.Provides
import hessam.rastegari.pnewsapp.data.api.TMDBService
import hessam.rastegari.pnewsapp.data.repository.artist.datasource.ArtistRemoteDatasource
import hessam.rastegari.pnewsapp.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import hessam.rastegari.pnewsapp.data.repository.movie.datasource.MovieRemoteDatasource
import hessam.rastegari.pnewsapp.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasource.TVShowRemoteDatasource
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasourceImpl.TVShowRemoteDatasourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDatasource(tmdbService: TMDBService):MovieRemoteDatasource{
        return MovieRemoteDatasourceImpl(
            tmdbService,apiKey
        )
    }


    @Singleton
    @Provides
    fun provideTVShowRemoteDatasource(tmdbService: TMDBService):TVShowRemoteDatasource{
        return TVShowRemoteDatasourceImpl(
            tmdbService,apiKey
        )
    }


    @Singleton
    @Provides
    fun provideArtistRemoteDatasource(tmdbService: TMDBService):ArtistRemoteDatasource{
        return ArtistRemoteDatasourceImpl(
            tmdbService,apiKey
        )
    }
}