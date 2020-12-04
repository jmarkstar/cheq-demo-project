package com.jmarkstar.cheqdemoproj.repositories.local.entities

import androidx.room.Entity
import androidx.room.Index

@Entity(tableName = "spending_categories",
    indices = [Index("name")],
    primaryKeys = ["id"])

data class SpendingCategory(val id: Int,
                            val name: String,
                            val iconName: String)