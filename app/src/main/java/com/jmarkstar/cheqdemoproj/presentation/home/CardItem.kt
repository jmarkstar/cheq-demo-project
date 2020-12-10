package com.jmarkstar.cheqdemoproj.presentation.home

import com.jmarkstar.cheqdemoproj.BR
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.presentation.common.recyclerview.RecyclerItem

data class CardItem(val bankName: String,
                    val bankIcon: String,
                    val balance: String,
                    val spent: String,
                    val income: String,
                    val syncDate: String,
                    val isAllAccount: Boolean = false)

fun CardItem.toRecyclerItem() = RecyclerItem(this, R.layout.view_card_item, BR.cardItem)

fun ArrayList<CardItem>.toRecyclerItems() = map { it.toRecyclerItem() }