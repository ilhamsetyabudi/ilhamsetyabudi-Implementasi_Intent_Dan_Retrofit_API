package com.bootcamp.tugas3ilhamsetyabudi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.tugas3ilhamsetyabudi.adapter.NewsAdapter
import com.bootcamp.tugas3ilhamsetyabudi.api.ApiConfig
import com.bootcamp.tugas3ilhamsetyabudi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Home"

        ApiConfig.getService().getNews("id", "f044de69086e45198f8406be2094a229").enqueue(object : Callback<ResponseNews>{
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                Log.d("RESPONE",response.isSuccessful.toString())
                if(response.isSuccessful){
                    val responseNews=response.body()
                    val dataNews = responseNews?.articles
                    val newsAdapter= NewsAdapter()
                    newsAdapter.setData(dataNews as List<ArticlesItem>)
                    binding.rvNews.apply {
                        layoutManager=LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        adapter = newsAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                Log.d("gagal","onFailure: "+ t.localizedMessage)
            }

        })
    }
}