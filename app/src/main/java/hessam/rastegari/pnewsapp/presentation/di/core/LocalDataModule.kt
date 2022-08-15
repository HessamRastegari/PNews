package hessam.rastegari.pnewsapp.presentation.di.core

import dagger.Module
import dagger.Provides
import hessam.rastegari.pnewsapp.data.db.ArtistDAO
import hessam.rastegari.pnewsapp.data.db.MovieDAO
import hessam.rastegari.pnewsapp.data.db.TVShowDAO
import hessam.rastegari.pnewsapp.data.repository.artist.datasource.ArtistLocalDatasource
import hessam.rastegari.pnewsapp.data.repository.artist.datasourceImpl.ArtistLocalDatasourceImpl
import hessam.rastegari.pnewsapp.data.repository.movie.datasource.MovieLocalDatasource
import hessam.rastegari.pnewsapp.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasource.TVShowLocalDatasource
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasourceImpl.TVShowLocalDatasourceImpl
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasourceImpl.TVShowRemoteDatasourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDatasource{
        return MovieLocalDatasourceImpl(movieDAO)
    }


    @Singleton
    @Provides
    fun provideTVShowLocalDataSource(tvShowDAO: TVShowDAO): TVShowLocalDatasource{
        return TVShowLocalDatasourceImpl(tvShowDAO)
    }



    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDAO: ArtistDAO): ArtistLocalDatasource{
        return ArtistLocalDatasourceImpl(artistDAO)
    }


}