package com.jmarkstar.cheqdemoproj.repositories.local.daos

import androidx.room.Dao
import androidx.room.Query

/* Bank Dao
* */
@Dao interface BankDao {

    @Query("SELECT COUNT(id) FROM banks")
    suspend fun count(): Int
}