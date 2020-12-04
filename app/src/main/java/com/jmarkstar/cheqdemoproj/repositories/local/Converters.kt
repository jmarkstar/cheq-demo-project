package com.jmarkstar.cheqdemoproj.repositories.local

import androidx.room.TypeConverter
import com.jmarkstar.cheqdemoproj.models.TransactionType

class Converters {

    companion object {

        @TypeConverter
        @JvmStatic
        fun toTransactionType(code: Int): TransactionType = if (code == 0) TransactionType.SPENDING else TransactionType.INCOMING

        @TypeConverter
        @JvmStatic
        fun toInteger(status: TransactionType): Int = status.code

    }
}