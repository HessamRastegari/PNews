package hessam.rastegari.pnewsapp.data.model.artist


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "artist_list")
data class ArtistList(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val artists: List<Artist>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)