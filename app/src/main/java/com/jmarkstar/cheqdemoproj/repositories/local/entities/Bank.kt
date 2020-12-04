package com.jmarkstar.cheqdemoproj.repositories.local.entities

import androidx.room.Entity
import androidx.room.Index

@Entity(tableName = "banks",
    indices = [Index("name")],
    primaryKeys = ["id"])

data class Bank(val id: Int,
                val name: String,
                val localBankIcon: String)