package com.jmarkstar.cheqdemoproj.presentation.home

data class CardItem(val bankName: String,
                    val bankIcon: String,
                    val balance: String,
                    val spent: String,
                    val income: String,
                    val syncDate: String,
                    val isAllAccount: Boolean = false)