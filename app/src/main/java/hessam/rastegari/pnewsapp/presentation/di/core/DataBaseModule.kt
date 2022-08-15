package hessam.rastegari.pnewsapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import hessam.rastegari.pnewsapp.data.db.ArtistDAO
import hessam.rastegari.pnewsapp.data.db.MovieDAO
import hessam.rastegari.pnewsapp.data.db.PNewsDatabase
import hessam.rastegari.pnewsapp.data.db.TVShowDAO
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabse(context: Context):PNewsDatabase{
        return Room.databaseBuilder(context, PNewsDatabase::class.java, "pnewsclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(pNewsDatabase: PNewsDatabase):MovieDAO{
        return pNewsDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTVShowDAO(pNewsDatabase: PNewsDatabase):TVShowDAO{
        return pNewsDatabase.tvShowDAO()
    }

    @Singleton
    @Provides
    fun provideArtistDAO(pNewsDatabase: PNewsDatabase):ArtistDAO{
        return pNewsDatabase.artistDAO()
    }
}