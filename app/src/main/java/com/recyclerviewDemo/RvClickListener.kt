package com.recyclerviewDemo

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.recyclerviewDemo.adapter.GlobalAdapter

interface RvClickListener {
    fun click(
        view: View,
        item: Any?,
        position: Int,
        adapter: GlobalAdapter<Any>
    )
}