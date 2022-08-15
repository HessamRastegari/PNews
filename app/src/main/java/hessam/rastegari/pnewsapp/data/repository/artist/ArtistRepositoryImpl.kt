package hessam.rastegari.pnewsapp.data.repository.artist

import android.util.Log
import hessam.rastegari.pnewsapp.data.model.artist.Artist
import hessam.rastegari.pnewsapp.data.repository.artist.datasource.ArtistCacheDatasource
import hessam.rastegari.pnewsapp.data.repository.artist.datasource.ArtistLocalDatasource
import hessam.rastegari.pnewsapp.data.repository.artist.datasource.ArtistRemoteDatasource
import hessam.rastegari.pnewsapp.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource,

    ) : ArtistRepository {
    override suspend fun getArtist(): List<Artist> {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist> {
        val newListOfArtist = getArtistFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistToDB(newListOfArtist)
        artistCacheDatasource.saveArtistToCache(newListOfArtist)
        return newListOfArtist
    }

    private suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDatasource.getArtist()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (e: Exception) {
            Log.i("MYTAG", "error is : ${e.message}")
        }


        return artistList
    }

    private suspend fun getArtistFromDB(): List<Artist> {

        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDatasource.getArtistFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromAPI()
            artistLocalDatasource.saveArtistToDB(artistList)
        }
        return artistList
    }



    private suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDatasource.getArtistFromCache()
        } catch (e: Exception) {
            Log.i("MYTAG", "error is : ${e.message}")
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDatasource.saveArtistToCache(artistList)
        }
        return artistList
    }
}