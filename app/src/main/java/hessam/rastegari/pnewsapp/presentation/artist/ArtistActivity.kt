package hessam.rastegari.pnewsapp.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import hessam.rastegari.pnewsapp.R
import hessam.rastegari.pnewsapp.databinding.ActivityArtistBinding
import hessam.rastegari.pnewsapp.databinding.ActivityMovieBinding
import hessam.rastegari.pnewsapp.presentation.di.Injector
import hessam.rastegari.pnewsapp.presentation.di.artist.ArtistAdapter
import hessam.rastegari.pnewsapp.presentation.di.movie.MovieAdapter
import hessam.rastegari.pnewsapp.presentation.movie.MovieViewModel
import hessam.rastegari.pnewsapp.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {


    @Inject
    lateinit var factory: ArtistViewModelFactory

    private lateinit var artistViewModel: ArtistViewModel

    private lateinit var adapter: ArtistAdapter


    private lateinit var binding : ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_artist)

        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistViewModel = ViewModelProvider(this, factory)
            .get(ArtistViewModel::class.java)

        initRecyclerView()
    }


    private fun initRecyclerView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularMovies()

    }


    private fun displayPopularMovies() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtist()
        responseLiveData.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data Available", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator: MenuInflater = menuInflater
        inflator.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies(){
        binding.artistProgressBar.visibility= View.VISIBLE
        val response = artistViewModel.updateArtist()
        response.observe(this, Observer {
            if(it!=null){

                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE

            }else{
                binding.artistProgressBar.visibility = View.GONE
            }
        })
    }
}