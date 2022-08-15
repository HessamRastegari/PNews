package hessam.rastegari.pnewsapp.presentation.di.core

import dagger.Module
import dagger.Provides
import hessam.rastegari.pnewsapp.data.repository.artist.datasource.ArtistCacheDatasource
import hessam.rastegari.pnewsapp.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import hessam.rastegari.pnewsapp.data.repository.movie.datasource.MovieCacheDatasource
import hessam.rastegari.pnewsapp.data.repository.movie.datasourceImpl.MovieCacheDatasourceImpl
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasource.TVShowCacheDatasource
import hessam.rastegari.pnewsapp.data.repository.tvshow.datasourceImpl.TVShowCacheDatasourceImpl
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun cacheMovieCacheDataSource(): MovieCacheDatasource{
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun cacheTVShowCacheDataSource(): TVShowCacheDatasource {
        return TVShowCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun cacheArtistCacheDataSource(): ArtistCacheDatasource {
        return ArtistCacheDatasourceImpl()
    }
}