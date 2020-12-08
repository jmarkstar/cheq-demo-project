package com.jmarkstar.cheqdemoproj.repositories.local.entities

import android.content.ContentValues
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.jmarkstar.cheqdemoproj.models.TransactionType

@Entity(tableName = "transactions",
    indices = [Index("bankAccountId")],
    foreignKeys = [ForeignKey(entity = BankAccount::class, parentColumns = arrayOf("id"),
            childColumns = arrayOf("bankAccountId"), onDelete = ForeignKey.CASCADE)])

data class Transaction(@PrimaryKey(autoGenerate = true) val id: Int? = null,
                       val bankAccountId: Int,
                       val type: TransactionType,
                       val amount: Double,
                       val timestamp: Long,
                       val syncTimestamp: Long,
                       val spendingCategoryId: Int? = null) {

    fun toContentValues() = ContentValues().apply {
        if (id != null) this.put("id", id)
        this.put("bankAccountId", bankAccountId)
        this.put("type", type.code)
        this.put("amount", amount)
        this.put("timestamp", timestamp)
        this.put("syncTimestamp", syncTimestamp)
        if (spendingCategoryId != null) this.put("spendingCategoryId", spendingCategoryId)
    }
}