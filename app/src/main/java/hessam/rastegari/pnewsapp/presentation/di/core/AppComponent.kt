package hessam.rastegari.pnewsapp.presentation.di.core

import dagger.Component
import dagger.Module
import hessam.rastegari.pnewsapp.presentation.di.artist.ArtistSubComponent
import hessam.rastegari.pnewsapp.presentation.di.movie.MovieSubComponent
import hessam.rastegari.pnewsapp.presentation.di.tvshow.TVShowSubComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TVShowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory

}