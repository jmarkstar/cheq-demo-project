package com.jmarkstar.cheqdemoproj.common.presentation

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jmarkstar.cheqdemoproj.common.presentation.custom_views.BalanceCardView
import com.jmarkstar.cheqdemoproj.common.presentation.recyclerview.OnRecyclerItemClick
import com.jmarkstar.cheqdemoproj.common.presentation.recyclerview.RecyclerItem
import com.jmarkstar.cheqdemoproj.common.presentation.recyclerview.RecyclerViewAdapter
import com.jmarkstar.cheqdemoproj.presentation.home.CardItem

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

@BindingAdapter("cardItem")
fun setCardItem(view: BalanceCardView, cardItem: CardItem?) {
    view.cardItem = cardItem
}

@BindingAdapter("items", "onItemClick")
fun setRecyclerViewItems(
    recyclerView: RecyclerView,
    items: List<RecyclerItem>?,
    onItemClick: OnRecyclerItemClick?
) {
    var adapter = (recyclerView.adapter as? RecyclerViewAdapter)
    if (adapter == null) {
        adapter = RecyclerViewAdapter()
        onItemClick?.apply {
            adapter.onItemClick = onItemClick
        }
        recyclerView.adapter = adapter
    }

    adapter.updateData(items.orEmpty())
}
