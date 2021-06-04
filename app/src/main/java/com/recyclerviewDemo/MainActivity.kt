package com.recyclerviewDemo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.recyclerviewDemo.adapter.GlobalAdapter
import com.recyclerviewDemo.databinding.ActivityMainBinding
import com.recyclerviewDemo.model.Listing

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
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
            MutableLiveData(
                listOf(
                    Listing.StringData(
                        "First Data",
                        MutableLiveData(
                            listOf(
                                Listing.StringData.StringTwo("Second Data"),
                                Listing.StringData.StringTwo("Second Data"),
                                Listing.StringData.StringTwo("Second Data"),
                                Listing.StringData.StringTwo("Second Data")
                            )
                        )
                    ),
                    Listing.StringData(
                        "Second Data",
                        MutableLiveData(listOf(Listing.StringData.StringTwo("Third Data")))
                    ),
                    Listing.StringData(
                        "Third Data",
                        MutableLiveData(listOf(Listing.StringData.StringTwo("Forth Data")))
                    ),
                    Listing.StringData(
                        "Forth Data",
                        MutableLiveData(listOf(Listing.StringData.StringTwo("Fifth Data")))
                    ),
                    Listing.StringData(
                        "Fifth Data",
                        MutableLiveData(listOf(Listing.StringData.StringTwo("Sixth Data")))
                    ),
                    Listing.StringData(
                        "Sixth Data",
                        MutableLiveData(listOf(Listing.StringData.StringTwo("Seventh Data")))
                    ),
                    Listing.StringData(
                        "Seventh Data",
                        MutableLiveData(listOf(Listing.StringData.StringTwo("Eighth Data")))
                    ),
                    Listing.StringData(
                        "Eighth Data",
                        MutableLiveData(listOf(Listing.StringData.StringTwo("Nine Data")))
                    ),
                    Listing.StringData(
                        "Nine Data",
                        MutableLiveData(listOf(Listing.StringData.StringTwo("Tenth Data")))
                    ),
                    Listing.StringData(
                        "Tenth Data",
                        MutableLiveData(listOf(Listing.StringData.StringTwo("Eleventh Data")))
                    ),
                    Listing.StringData(
                        "Eleventh Data",
                        MutableLiveData(listOf(Listing.StringData.StringTwo("twevlth Data")))
                    )
                )
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
                    is Listing.StringData.StringTwo -> {
                        when (view.id) {
                            R.id.tv_nested_news_title -> {
                                view as TextView
                                binding.model?.first?.value!!.toMutableList()[(binding.rvNews.adapter as GlobalAdapter<Any>).holderr.adapterPosition].second.value!!.toMutableList()
                                    .removeAt(position)
                                adapter.mutableList.value!!.removeAt(position)
                                adapter.notifyItemRemoved(position)
                                Toast.makeText(
                                    this@MainActivity,
                                    "${adapter.mutableList.value!!.size}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                    is Listing.StringData -> {
                        when (view.id) {
                            R.id.tv_news_title -> {
                                view as TextView
                                view.setTextColor(Color.CYAN)
                                item.title = "OH NO!"
                                adapter.notifyItemChanged(position)
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