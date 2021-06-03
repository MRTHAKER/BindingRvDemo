package com.recyclerviewDemo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.recyclerviewDemo.adapter.GlobalAdapter
import com.recyclerviewDemo.databinding.ActivityMainBinding
import com.recyclerviewDemo.model.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var newsList: List<Articles>
    lateinit var mainClickListener: RvClickListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
        binding.itemclick = mainClickListener
        //setAdapter()
        binding.click = this@MainActivity
        binding.model = Listing(
            listOf(
                StringData(
                    "First Data",
                    listOf(
                        StringTwo("Second Data"),
                        StringTwo("Second Data"),
                        StringTwo("Second Data"),
                        StringTwo("Second Data")
                    )
                ),
                StringData("Second Data", listOf(StringTwo("Third Data"))),
                StringData("Third Data", listOf(StringTwo("Forth Data"))),
                StringData("Forth Data", listOf(StringTwo("Fifth Data"))),
                StringData("Fifth Data", listOf(StringTwo("Sixth Data"))),
                StringData("Sixth Data", listOf(StringTwo("Seventh Data"))),
                StringData("Seventh Data", listOf(StringTwo("Eighth Data"))),
                StringData("Eighth Data", listOf(StringTwo("Nine Data"))),
                StringData("Nine Data", listOf(StringTwo("Tenth Data"))),
                StringData("Tenth Data", listOf(StringTwo("Eleventh Data"))),
                StringData("Eleventh Data", listOf(StringTwo("twevlth Data")))
            )
        )
        /*CoroutineScope(Dispatchers.IO).launch {
            //val x = ArticlesService.articlesInstance.getNews("India")
            newsList = x.articles
            newsList.forEach {
                it.article = x.articles
            }
            withContext(Dispatchers.Main) {
                //adapter.addData(newsList)
                binding.model = x
            }
        }*/

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
                    /*is Articles -> {
                        when (view.id) {
                            R.id.rv_nested_news_main_cv -> {
                                adapter as GlobalAdapter<Articles>
                                view as MaterialCardView
                                Toast.makeText(this@MainActivity, "card click", Toast.LENGTH_SHORT)
                                    .show()
                                adapter.mutableList.removeAt(position)
                                adapter.notifyItemRemoved(position)
                            }
                        }
                    }
                }*/
                    is StringTwo -> {
                        when (view.id) {
                            R.id.tv_nested_news_title -> {
                                /*view as TextView
                                adapter.mutableList.removeAt(holder.adapterPosition)
                                adapter.notifyItemRemoved(holder.adapterPosition)
                                adapter.notifyItemRangeChanged(holder.adapterPosition,adapter.mutableList.size)
                                adapter.notifyDataSetChanged()
                                Toast.makeText(
                                    this@MainActivity,
                                    "${adapter.mutableList.size}",
                                    Toast.LENGTH_SHORT
                                ).show()*/
                                view as TextView
                                view.setTextColor(Color.CYAN)
                                item.description="OH Okay"
                                adapter.notifyDataSetChanged()
                            }
                        }
                    }
                    is StringData -> {
                        when (view.id) {
                            R.id.tv_news_title -> {
                                view as TextView
                                view.setTextColor(Color.CYAN)
                                item.title="OH NO!"
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