package com.jmarkstar.cheqdemoproj.repositories.local.daos

import androidx.room.Dao
import androidx.room.Query
import com.jmarkstar.cheqdemoproj.models.Expense

/* Transaction Dao
* */
@Dao interface TransactionDao {

    @Query("SELECT COUNT(id) FROM transactions")
    suspend fun count(): Int

    @Query("""
            SELECT sc.name as spendingCategoryName, 
            sc.iconName as spendingCategoryIcon, 
            SUM(t.amount) as total,
            strftime("%Y-%m", t.timestamp/1000, "unixepoch") as registrationMonth
            FROM transactions t
            INNER JOIN spending_categories sc ON t.spendingCategoryId = sc.id 
            INNER JOIN bank_accounts ba ON t.bankAccountId = ba.id 
            WHERE t.type = 0
            GROUP BY spendingCategoryName, registrationMonth
    """)
    suspend fun getExpensesByMonthAndCategory(): List<Expense>
}