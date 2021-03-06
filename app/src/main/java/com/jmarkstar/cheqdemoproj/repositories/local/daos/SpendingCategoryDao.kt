package com.jmarkstar.cheqdemoproj.repositories.local.daos

import androidx.room.Dao
import androidx.room.Query
import com.jmarkstar.cheqdemoproj.repositories.local.entities.SpendingCategory

/* SpendingCategory Dao
* */
@Dao
interface SpendingCategoryDao {

    @Query("SELECT COUNT(id) FROM spending_categories")
    suspend fun count(): Int

    @Query("SELECT * FROM spending_categories")
    suspend fun getAllSpendingCategories(): List<SpendingCategory>
}
