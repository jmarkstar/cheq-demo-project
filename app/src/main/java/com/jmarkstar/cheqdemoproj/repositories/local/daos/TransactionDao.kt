package com.jmarkstar.cheqdemoproj.repositories.local.daos

import androidx.room.Dao
import androidx.room.Query
import com.jmarkstar.cheqdemoproj.repositories.local.entities.Transaction

/* This dao has random methods which won't be used on the app.
* */
@Dao interface TransactionDao {

    @Query("SELECT COUNT(id) FROM transactions WHERE bankAccountId = :idBankAccount")
    suspend fun countTransactionsBy(idBankAccount: Int): Int

    @Query("SELECT * FROM transactions WHERE bankAccountId = :idBankAccount")
    suspend fun getTransactionsBy(idBankAccount: Int): List<Transaction>
}