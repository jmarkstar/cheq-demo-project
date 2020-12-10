package com.jmarkstar.cheqdemoproj.presentation.common

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jmarkstar.cheqdemoproj.presentation.common.recyclerview.RecyclerItem
import com.jmarkstar.cheqdemoproj.presentation.common.recyclerview.RecyclerViewAdapter

@BindingAdapter("srcName")
fun setDrawableByName(imageView: ImageView, srcName: String?) {
    if (!srcName.isNullOrEmpty()) {
        imageView.setImageDrawable(imageView.context.getDrawableByName(srcName))
    }
}

@BindingAdapter("android:visibility")
fun setVisibility(view: View, value: Boolean) {
    view.visibility = if (value) View.VISIBLE else View.GONE
}

@BindingAdapter("items")
fun setRecyclerViewItems(recyclerView: RecyclerView, items: List<RecyclerItem>?) {
    var adapter = (recyclerView.adapter as? RecyclerViewAdapter)
    if (adapter == null) {
        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter
    }

    adapter.updateData(items.orEmpty())
}