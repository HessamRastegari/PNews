package hessam.rastegari.pnewsapp.presentation

import android.app.Application
import hessam.rastegari.pnewsapp.BuildConfig
import hessam.rastegari.pnewsapp.presentation.di.Injector
import hessam.rastegari.pnewsapp.presentation.di.artist.ArtistSubComponent
import hessam.rastegari.pnewsapp.presentation.di.core.*
import hessam.rastegari.pnewsapp.presentation.di.movie.MovieSubComponent
import hessam.rastegari.pnewsapp.presentation.di.tvshow.TVShowSubComponent

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTVShowSubComponent(): TVShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}