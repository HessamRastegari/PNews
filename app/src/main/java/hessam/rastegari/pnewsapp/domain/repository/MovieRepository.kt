package hessam.rastegari.pnewsapp.domain.repository

import hessam.rastegari.pnewsapp.data.model.artist.Artist
import hessam.rastegari.pnewsapp.data.model.movie.Movie
import hessam.rastegari.pnewsapp.data.model.tvshow.TVShow

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?



}