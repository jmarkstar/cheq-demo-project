package com.jmarkstar.cheqdemoproj.presentation.home

import android.os.Parcelable
import com.jmarkstar.cheqdemoproj.BR
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.common.presentation.recyclerview.RecyclerItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardItem(val bankName: String,
                    val bankIcon: String,
                    val balance: String,
                    val spent: String,
                    val income: String,
                    val syncDate: String,
                    val isAllAccount: Boolean = false) : Parcelable

fun CardItem.toRecyclerItem() = RecyclerItem(this, R.layout.fragment_home_cards_item, BR.cardItem)

fun ArrayList<CardItem>.toRecyclerItems() = map { it.toRecyclerItem() }