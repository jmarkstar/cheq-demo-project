package com.jmarkstar.cheqdemoproj.repositories.local.entities

import androidx.room.Entity
import androidx.room.Index

@Entity(tableName = "bank_accounts",
    indices = [Index(value = ["bankId", "accountNumber"], unique = true)],
    primaryKeys = ["id"])

data class BankAccount(val id: Int,
                  val bankId: Int,
                  val accountNumber: String,
                  val accountName: String)