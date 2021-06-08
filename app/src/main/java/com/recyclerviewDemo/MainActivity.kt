package com.recyclerviewDemo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.recyclerviewDemo.adapter.GlobalAdapter
import com.recyclerviewDemo.databinding.ActivityMainBinding
import com.recyclerviewDemo.model.Articles
import com.recyclerviewDemo.model.News
import com.recyclerviewDemo.model.NewsCategory

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainClickListener: RvClickListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
        binding.itemclick = mainClickListener
        binding.click = this@MainActivity
        binding.model = giveModel()
    }

    private fun giveModel(): News {
        return News(
            listOf(
                NewsCategory(
                    "Entertainment",
                    listOf(
                        Articles(
                            "Entertainment Article 1 Title 1",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo1.png",
                            "Entertainment Article Description 1"
                        ), Articles(
                            "Entertainment Article Title 2",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo2.png",
                            "Entertainment Article Description 2"
                        ), Articles(
                            "Entertainment Article Title 3",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo3.png",
                            "Entertainment Article Description 3"
                        )
                    )
                ),
                NewsCategory(
                    "Sports",
                    listOf(
                        Articles(
                            "Sports Article Title 1",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo1.png",
                            "Sports Article Description 1"
                        ), Articles(
                            "Sports Article Title 2",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo2.png",
                            "Sports Article Description 2"
                        ), Articles(
                            "Sports Article Title 3",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo3.png",
                            "Sports Article Description 3"
                        )
                    )
                ),
                NewsCategory(
                    "Technology",
                    listOf(
                        Articles(
                            "Technology Article Title 1",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo1.png",
                            "Technology Article Description 1"
                        ), Articles(
                            "Technology Article Title 2",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo2.png",
                            "Technology Article Description 2"
                        ), Articles(
                            "Technology Article Title 3",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo3.png",
                            "Technology Article Description 3"
                        )
                    )
                ),
                NewsCategory(
                    "Business",
                    listOf(
                        Articles(
                            "Business Article Title 1",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo1.png",
                            "Business Article Description 1"
                        ), Articles(
                            "Business Article Title 2",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo2.png",
                            "Business Article Description 2"
                        ), Articles(
                            "Business Article Title 3",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo3.png",
                            "Business Article Description 3"
                        )
                    )
                ),
                NewsCategory(
                    "International",
                    listOf(
                        Articles(
                            "International Article Title 1",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo1.png",
                            "International Article Description 1"
                        ), Articles(
                            "International Article Title 2",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo2.png",
                            "International Article Description 2"
                        ), Articles(
                            "International Article Title 3",
                            "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo3.png",
                            "International Article Description 3"
                        )
                    )
                )
            )
        )
    }

    private fun setListeners() {
        mainClickListener = object : RvClickListener {
            override fun click(
                view: View,
                item: Any?,
                position: Int,
                adapter: GlobalAdapter<Any>,
            ) {
                when (item) {
                    is Articles -> {
                        when (view.id) {
                            R.id.rv_nested_news_main_cv -> {
                                view as MaterialCardView
                                adapter as GlobalAdapter<Articles>
                                adapter.mutableList.map {
                                    it.isChecked = false
                                }
                                item.isChecked = true
                                adapter.notifyItemRangeChanged(0, adapter.itemCount)
                            }
                        }
                    }
                    is NewsCategory -> {
                        when (view.id) {
                            R.id.rv_news_main_cv -> {
                                view as MaterialCardView
                                view.background.setTint(Color.CYAN)
                                Toast.makeText(this@MainActivity, "$position", Toast.LENGTH_SHORT)
                                    .show()
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