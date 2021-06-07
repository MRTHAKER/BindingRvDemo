package com.recyclerviewDemo

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.recyclerviewDemo.adapter.GlobalAdapter
import com.recyclerviewDemo.databinding.ActivityMainBinding
import com.recyclerviewDemo.model.Articles
import com.recyclerviewDemo.model.News
import com.recyclerviewDemo.model.NewsCategory

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var mainClickListener: RvClickListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
        binding.itemclick = mainClickListener
        binding.click = this@MainActivity
        binding.model = News()

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
                                adapter.mutableList.removeAt(position)
                                adapter.notifyItemRemoved(position)
                            }

                        }
                    }
                    is NewsCategory -> {
                        when (view.id) {
                            R.id.rv_news_main_cv -> {
                                view as MaterialCardView
                                view.background.setTint(Color.CYAN)
                                Toast.makeText(this@MainActivity,"$position",Toast.LENGTH_SHORT).show()
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