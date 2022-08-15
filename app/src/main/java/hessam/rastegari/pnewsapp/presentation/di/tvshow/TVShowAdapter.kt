package hessam.rastegari.pnewsapp.presentation.di.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hessam.rastegari.pnewsapp.R
import hessam.rastegari.pnewsapp.data.model.movie.Movie
import hessam.rastegari.pnewsapp.data.model.tvshow.TVShow
import hessam.rastegari.pnewsapp.databinding.ListItemBinding

class TVShowAdapter(): RecyclerView.Adapter<MyViewHolder>() {

    private val tvshowList  = ArrayList<TVShow>()

    fun setList(tvshows:List<TVShow>){
        tvshowList.clear()
        tvshowList.addAll(tvshows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvshowList[position])
    }

    override fun getItemCount(): Int {
        return tvshowList.size
    }

}




class MyViewHolder(val binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root){


        fun bind(tvshow:TVShow){
            binding.titleTextView.text = tvshow.name
            binding.descriptionTextView.text  = tvshow.overview
            val posterURL = "https://image.tmdb.org/t/p/w500" + tvshow.posterPath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }
    }

