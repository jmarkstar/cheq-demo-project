package com.jmarkstar.cheqdemoproj.repositories.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jmarkstar.cheqdemoproj.repositories.local.entities.BankAccount

/* This dao has random methods which won't be used on the app.
* */
@Dao interface BankAccountDao {

    @Query("SELECT COUNT(id) FROM bank_accounts")
    suspend fun count(): Int

    @Query("SELECT * FROM bank_accounts WHERE bankId = :bankId")
    suspend fun getBankAccountsBy(bankId: Int): List<BankAccount>

    @Query("SELECT * FROM bank_accounts WHERE id = :id")
    suspend fun getBankAccountById(id: Int): BankAccount?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(newAccounts: List<BankAccount>): List<Long>

    @Query("DELETE FROM bank_accounts")
    suspend fun deleteAll(): Int
}