package hessam.rastegari.pnewsapp.presentation.di.movie

import dagger.Subcomponent
import hessam.rastegari.pnewsapp.presentation.artist.ArtistActivity
import hessam.rastegari.pnewsapp.presentation.movie.MovieActivity

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}