package com.bootcamp.tugas3ilhamsetyabudi.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.tugas3ilhamsetyabudi.ArticlesItem
import com.bootcamp.tugas3ilhamsetyabudi.DetailNewsActivity
import com.bootcamp.tugas3ilhamsetyabudi.R
import com.bootcamp.tugas3ilhamsetyabudi.databinding.ItemRowNewsBinding
import com.bumptech.glide.Glide

class NewsAdapter():RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    private var dataNews: List<ArticlesItem> = listOf()

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val binding= ItemRowNewsBinding.bind(view)

        fun bind(news : ArticlesItem){
            binding.apply {
                tvJudul.text = news.title
                tvPenulis.text = news.author
                tvTanggalPosting.text = news.publishedAt

                Glide.with(imgNews)
                    .load(news.urlToImage)
                    .error(R.drawable.ic_launcher_background)
                    .into(imgNews)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailNewsActivity::class.java)
                    intent.putExtra(DetailNewsActivity.EXTRA_NEWS, news)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_news,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataNews.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataNews[position])
    }

    fun setData(data : List<ArticlesItem>){
        dataNews = data
        notifyDataSetChanged()
    }
}