package com.jmarkstar.cheqdemoproj.common.presentation.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.BindingViewHolder>() {

    var onItemClick: OnRecyclerItemClick? = null

    private val items = mutableListOf<RecyclerItem>()

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = getItem(position).layoutId

    private fun getItem(position: Int) = items[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder =
            BindingViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false))

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        getItem(position).bind(holder.binding)
        holder.binding.executePendingBindings()
    }

    fun updateData(newItems: List<RecyclerItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class BindingViewHolder(val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemClick?.onItemClick(items[adapterPosition], binding.root)
            }
        }
    }
}

fun interface OnRecyclerItemClick {
    fun onItemClick(recyclerItem: RecyclerItem, view: View)
}