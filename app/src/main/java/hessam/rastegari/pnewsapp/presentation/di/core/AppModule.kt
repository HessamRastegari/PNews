package hessam.rastegari.pnewsapp.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import hessam.rastegari.pnewsapp.presentation.di.artist.ArtistSubComponent
import hessam.rastegari.pnewsapp.presentation.di.movie.MovieSubComponent
import hessam.rastegari.pnewsapp.presentation.di.tvshow.TVShowSubComponent
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TVShowSubComponent::class,ArtistSubComponent::class])
class AppModule(private val context: Context) {


    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}