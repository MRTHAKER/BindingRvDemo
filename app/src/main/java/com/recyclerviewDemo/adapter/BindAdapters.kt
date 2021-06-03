package com.recyclerviewDemo.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.recyclerviewDemo.BR
import com.recyclerviewDemo.RvClickListener

object BindAdapters {
    @JvmStatic
    @BindingAdapter("layout", "list", "click", requireAll = false)
    fun <T> setRecyclerView(
        view: RecyclerView,
        layout: Int,
        list: List<T>?,
        click: RvClickListener
    ) {
        if (list != null) {
            val x= mutableListOf<T>()
            list.forEach {
                x.add(it)
            }
            view.adapter = GlobalAdapter(
                layout,
                x,
                BR.model,
                clickListener = click,
                mapOf(BR.itemclick to click))
        }
    }

    @JvmStatic
    @BindingAdapter("urlToImage")
    fun loadImageFromUrl(view: ImageView, urlToImage: String) {
        Glide.with(view.context).load(urlToImage).into(view)
    }
}