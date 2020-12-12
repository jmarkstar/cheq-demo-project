package com.jmarkstar.cheqdemoproj.repositories.local.entities

import android.content.ContentValues
import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "spending_categories",
    indices = [Index("name")],
    primaryKeys = ["id"]
)

data class SpendingCategory(
    val id: Int,
    val name: String,
    val iconName: String
) {

    fun toContentValues() = ContentValues().apply {
        this.put("id", id)
        this.put("name", name)
        this.put("iconName", iconName)
    }
}
