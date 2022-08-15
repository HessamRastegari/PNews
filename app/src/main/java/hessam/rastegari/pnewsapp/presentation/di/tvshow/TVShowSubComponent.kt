package hessam.rastegari.pnewsapp.presentation.di.tvshow

import dagger.Subcomponent
import hessam.rastegari.pnewsapp.presentation.artist.ArtistActivity
import hessam.rastegari.pnewsapp.presentation.tvshow.TVShowActivity

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubComponent {
    fun inject(tvShowActivity: TVShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TVShowSubComponent
    }
}