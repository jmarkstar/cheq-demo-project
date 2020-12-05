package com.jmarkstar.cheqdemoproj.models

import java.util.*

data class Balance(val bankName: String,
                    val bankIcon: String,
                    val bankAccountName: String,
                    val date: Date,
                    val totalExpenses: Double,
                    val totalIncome: Double)