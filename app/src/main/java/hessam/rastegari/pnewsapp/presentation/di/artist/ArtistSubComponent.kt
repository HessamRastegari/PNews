package hessam.rastegari.pnewsapp.presentation.di.artist

import dagger.Subcomponent
import hessam.rastegari.pnewsapp.presentation.artist.ArtistActivity

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }
}