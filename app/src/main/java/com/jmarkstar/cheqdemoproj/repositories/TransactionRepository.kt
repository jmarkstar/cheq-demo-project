package com.jmarkstar.cheqdemoproj.repositories

import com.jmarkstar.cheqdemoproj.models.Expense

interface TransactionRepository {

    suspend fun getExpensesByCategoryPerMonth(): List<Expense>
}
