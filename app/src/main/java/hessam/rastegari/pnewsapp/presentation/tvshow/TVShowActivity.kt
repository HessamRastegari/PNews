package hessam.rastegari.pnewsapp.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import hessam.rastegari.pnewsapp.R
import hessam.rastegari.pnewsapp.databinding.ActivityTvShowBinding

class TVShowActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
    }
}