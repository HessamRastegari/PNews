package hessam.rastegari.pnewsapp.presentation.di

import hessam.rastegari.pnewsapp.presentation.di.artist.ArtistSubComponent
import hessam.rastegari.pnewsapp.presentation.di.movie.MovieSubComponent
import hessam.rastegari.pnewsapp.presentation.di.tvshow.TVShowSubComponent

interface Injector {

    fun createMovieSubComponent():MovieSubComponent
    fun createTVShowSubComponent():TVShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}