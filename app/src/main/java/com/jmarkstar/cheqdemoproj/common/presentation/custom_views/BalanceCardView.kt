package com.jmarkstar.cheqdemoproj.common.presentation.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.databinding.ViewBalanceCardBinding
import com.jmarkstar.cheqdemoproj.presentation.home.CardItem

class BalanceCardView : LinearLayout {

    private val binding = ViewBalanceCardBinding.inflate(LayoutInflater.from(context), this, false)

    var cardItem: CardItem?
        get() = binding.cardItem
        set(value) {
            value?.apply {
                binding.cardItem = this
                setBackgroundResource(if (isAllAccount) R.drawable.bg_all_account_card else R.drawable.bg_bank_card)
            }
        }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrSet: AttributeSet) : super(context, attrSet)
    constructor(context: Context, attrSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrSet,
        defStyleAttr
    )

    init {
        orientation = VERTICAL
        addView(binding.root)
    }
}
