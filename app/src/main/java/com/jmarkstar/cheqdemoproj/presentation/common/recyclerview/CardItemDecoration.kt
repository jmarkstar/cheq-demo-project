package com.jmarkstar.cheqdemoproj.presentation.common.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jmarkstar.cheqdemoproj.R

// Decoration for list of cards.
class CardItemDecoration: RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent.layoutManager !is LinearLayoutManager) {
            throw IllegalStateException("SpacingItemDecoration can only be used with a LinearLayoutManager.")
        }

        val orientation = (parent.layoutManager as LinearLayoutManager).orientation
        val positionItem = parent.getChildAdapterPosition(view)
        val totalItems = parent.adapter?.itemCount ?: 0

        if (positionItem <= totalItems-1 && orientation == LinearLayoutManager.HORIZONTAL) {
            val spacePx = parent.context.resources.getDimensionPixelOffset(R.dimen.app_spacing)
            outRect.right = spacePx
            if (positionItem == 0) {
                outRect.left = spacePx
            }
        }
    }
}