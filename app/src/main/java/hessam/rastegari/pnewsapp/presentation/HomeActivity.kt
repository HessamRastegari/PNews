package hessam.rastegari.pnewsapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import hessam.rastegari.pnewsapp.R
import hessam.rastegari.pnewsapp.data.model.artist.Artist
import hessam.rastegari.pnewsapp.data.model.tvshow.TVShow
import hessam.rastegari.pnewsapp.databinding.ActivityHomeBinding
import hessam.rastegari.pnewsapp.presentation.artist.ArtistActivity
import hessam.rastegari.pnewsapp.presentation.movie.MovieActivity
import hessam.rastegari.pnewsapp.presentation.tvshow.TVShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.movieButton.setOnClickListener{
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener{
            val intent = Intent(this, TVShowActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener{
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }

    }
}