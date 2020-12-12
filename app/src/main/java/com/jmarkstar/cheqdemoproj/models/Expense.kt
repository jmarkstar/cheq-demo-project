package com.jmarkstar.cheqdemoproj.models

data class Expense(
    val spendingCategoryName: String,
    val spendingCategoryIcon: String,
    val total: Double,
    val registrationMonth: String
)
