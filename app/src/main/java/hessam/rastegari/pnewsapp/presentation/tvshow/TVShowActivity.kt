package hessam.rastegari.pnewsapp.presentation.tvshow

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
import hessam.rastegari.pnewsapp.databinding.ActivityMovieBinding
import hessam.rastegari.pnewsapp.databinding.ActivityTvShowBinding
import hessam.rastegari.pnewsapp.presentation.di.Injector
import hessam.rastegari.pnewsapp.presentation.di.movie.MovieAdapter
import hessam.rastegari.pnewsapp.presentation.di.tvshow.TVShowAdapter
import hessam.rastegari.pnewsapp.presentation.movie.MovieViewModel
import hessam.rastegari.pnewsapp.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class TVShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TVShowsViewModelFactory

    private lateinit var tvshowViewModel: TVShowViewModel

    private lateinit var adapter: TVShowAdapter

    private lateinit var binding : ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTVShowSubComponent()
            .inject(this)

        tvshowViewModel = ViewModelProvider(this, factory)
            .get(TVShowViewModel::class.java)

        initRecyclerView()
    }


    private fun initRecyclerView() {
        binding.tvshowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TVShowAdapter()
        binding.tvshowRecyclerView.adapter = adapter
        displayPopularTVShows()

    }


    private fun displayPopularTVShows() {
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvshowViewModel.getTVShows()
        responseLiveData.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvshowProgressBar.visibility = View.GONE
            } else {
                binding.tvshowProgressBar.visibility = View.GONE
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
        binding.tvshowProgressBar.visibility= View.VISIBLE
        val response = tvshowViewModel.updateTVShows()
        response.observe(this, Observer {
            if(it!=null){

                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvshowProgressBar.visibility = View.GONE

            }else{
                binding.tvshowProgressBar.visibility = View.GONE
            }
        })
    }
}