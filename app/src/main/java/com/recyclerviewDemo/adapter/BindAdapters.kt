package com.recyclerviewDemo.adapter

import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.recyclerviewDemo.BR
import com.recyclerviewDemo.RvClickListener

object BindAdapters {
    var counter=0
    var target=0
    @JvmStatic
    @BindingAdapter("layout", "list", "click","size", requireAll = false)
    fun <T> setRecyclerView(
        view: RecyclerView,
        layout: Int,
        list: MutableLiveData<List<T>>?,
        click: RvClickListener,
        size:Int
    ) {
        if (list != null) {
            target += size
            counter++
            val adapter = GlobalAdapter(
                layout,
                MutableLiveData(list.value!!.toMutableList()),
                BR.model,
                clickListener = click,
                mapOf(BR.itemclick to click)
            )
            view.adapter = adapter
            Toast.makeText(view.context,"Size of list $counter",Toast.LENGTH_SHORT).show()
        }
    }

    @JvmStatic
    @BindingAdapter("urlToImage")
    fun loadImageFromUrl(view: ImageView, urlToImage: String) {
        Glide.with(view.context).load(urlToImage).into(view)
    }
}