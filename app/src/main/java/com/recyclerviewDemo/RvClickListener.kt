package com.recyclerviewDemo

import android.view.SurfaceHolder
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.recyclerviewDemo.adapter.GlobalAdapter

interface RvClickListener{
    fun click(view: View, item: Any?, position:Int,holder: RecyclerView.ViewHolder,adapter: GlobalAdapter<Any>)
}