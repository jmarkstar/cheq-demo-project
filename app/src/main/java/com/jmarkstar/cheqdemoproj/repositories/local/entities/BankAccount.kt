package com.jmarkstar.cheqdemoproj.repositories.local.entities

import android.content.ContentValues
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(tableName = "bank_accounts",
    indices = [Index(value = ["bankId", "accountNumber"], unique = true)],
    primaryKeys = ["id"],
    foreignKeys = [ForeignKey(entity = Bank::class, parentColumns = arrayOf("id"),
            childColumns = arrayOf("bankId"), onDelete = ForeignKey.CASCADE)]
)

data class BankAccount(val id: Int,
                       val bankId: Int,
                       val accountNumber: String,
                       val accountName: String) {

    fun toContentValues() = ContentValues().apply {
        this.put("id", id)
        this.put("bankId", bankId)
        this.put("accountNumber", accountNumber)
        this.put("accountName", accountName)
    }
}