package com.bootcamp.tugas3ilhamsetyabudi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bootcamp.tugas3ilhamsetyabudi.databinding.ActivityDetailNewsBinding
import com.bumptech.glide.Glide

class DetailNewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNewsBinding

    companion object{
        const val EXTRA_NEWS = "extra_news"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title="Detail"

        val dataNews = intent.getParcelableExtra<ArticlesItem>(EXTRA_NEWS)

        binding.apply {
            tvJudul.text = dataNews?.title
            tvDeskripsi.text = dataNews?.description

            Glide.with(this@DetailNewsActivity)
                .load(dataNews?.urlToImage)
                .error(R.drawable.ic_launcher_background)
                .into(imgNews)
        }


    }
}