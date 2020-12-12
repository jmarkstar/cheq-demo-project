package com.jmarkstar.cheqdemoproj.models

data class Balance(
    val bankName: String,
    val bankIcon: String,
    val bankAccountName: String,
    val spent: Double,
    val income: Double,
    val syncDatetime: String
)
