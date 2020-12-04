package com.jmarkstar.cheqdemoproj.repositories.local.entities

import androidx.room.Entity
import androidx.room.Index
import com.jmarkstar.cheqdemoproj.models.TransactionType

@Entity(tableName = "transactions",
    indices = [Index("bankAccountId")],
    primaryKeys = ["id"])

data class Transaction(val id: Int,
                       val bankAccountId: Int,
                       val type: TransactionType,
                       val amount: Double,
                       val spendingCategoryId: Int? = null)