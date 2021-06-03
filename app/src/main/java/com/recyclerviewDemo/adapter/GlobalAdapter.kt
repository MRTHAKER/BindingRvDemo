package com.recyclerviewDemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.recyclerviewDemo.BR
import com.recyclerviewDemo.RvClickListener

class GlobalAdapter<T>(
    private val layoutId: Int,
    val mutableList: MutableList<T>,
    private val br: Int,
    private var clickListener:RvClickListener,
    private val brs :Map<Int,Any>?=null
) : androidx.recyclerview.widget.RecyclerView.Adapter<GlobalAdapter<T>.ViewHolder>() {
    private lateinit var binding: ViewDataBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.setVariable(br, mutableList[holder.adapterPosition])
        holder.setIsRecyclable(false)
        brs?.forEach {
            binding.setVariable(it.key,it.value)
        }
            holder.binding.setVariable(
                BR.click,
                View.OnClickListener { v ->
                    clickListener?.click(
                        v,
                        mutableList[holder.adapterPosition],
                        holder.adapterPosition,
                        holder,
                        this as GlobalAdapter<Any>
                    )
                })
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = mutableList.size

    fun addData(list: List<T>) {
        mutableList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ViewDataBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

    }
}