package com.recyclerviewDemo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.recyclerviewDemo.adapter.GlobalAdapter
import com.recyclerviewDemo.databinding.ActivityMainBinding
import com.recyclerviewDemo.model.Articles
import com.recyclerviewDemo.model.CandidateJobDetail
import com.recyclerviewDemo.model.Job
import com.recyclerviewDemo.model.PreviousJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var newsList:List<Articles>
    lateinit var mainClickListener: RvClickListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
        binding.itemclick = mainClickListener
        //setAdapter()
        binding.click = this@MainActivity
        CoroutineScope(Dispatchers.IO).launch {
            val x = ArticlesService.articlesInstance.getNews("India")
            newsList = x.articles
            newsList.forEach {
                it.article = x.articles
            }
            withContext(Dispatchers.Main) {
                //adapter.addData(newsList)
                binding.model = x
            }
        }
    }

    private fun setListeners() {
        mainClickListener = object : RvClickListener {
            override fun click(
                view: View,
                item: Any?,
                position: Int,
                holder: RecyclerView.ViewHolder,
                adapter: GlobalAdapter<Any>
            ) {
                when (item) {
                    is Articles -> {
                        when (view.id) {
                            R.id.rv_nested_news_main_cv -> {
                                adapter as GlobalAdapter<Articles>
                                view as MaterialCardView
                                Toast.makeText(this@MainActivity, "card click", Toast.LENGTH_SHORT)
                                    .show()
                                adapter.mutableList.map { it.isSelected = false }
                                item.isSelected = true
                                adapter.notifyDataSetChanged()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onClick(v: View?) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
    }
}