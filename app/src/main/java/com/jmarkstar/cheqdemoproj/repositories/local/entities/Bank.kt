package com.jmarkstar.cheqdemoproj.repositories.local.entities

import android.content.ContentValues
import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "banks",
    indices = [Index("name")],
    primaryKeys = ["id"]
)

data class Bank(
    val id: Int,
    val name: String,
    val localBankIcon: String
) {

    fun toContentValues() = ContentValues().apply {
        this.put("id", id)
        this.put("name", name)
        this.put("localBankIcon", localBankIcon)
    }
}
