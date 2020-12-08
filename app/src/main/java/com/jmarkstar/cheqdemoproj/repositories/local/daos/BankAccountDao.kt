package com.jmarkstar.cheqdemoproj.repositories.local.daos

import androidx.room.Dao
import androidx.room.Query

/* BankAccount Dao
* */
@Dao interface BankAccountDao {

    @Query("SELECT COUNT(id) FROM bank_accounts")
    suspend fun count(): Int
}