package com.jmarkstar.cheqdemoproj.repositories.local.daos

import androidx.room.Dao
import androidx.room.Query
import com.jmarkstar.cheqdemoproj.models.Balance

/* Bank Dao
* */
@Dao interface BankDao {

    @Query("SELECT COUNT(id) FROM banks")
    suspend fun count(): Int

    @Query(
            """
                SELECT
                b.name as bankName,
                b.localBankIcon as bankIcon,
                ba.accountName as bankAccountName,
                (SELECT SUM(t.amount) FROM transactions t WHERE t.type = 0 and t.bankAccountId = ba.id) as spent,
                (SELECT SUM(t.amount) FROM transactions t WHERE t.type = 1 and t.bankAccountId = ba.id) as income,
                strftime('%Y-%m-%d %H:%M:%S', t.syncTimestamp/1000, 'unixepoch', 'localtime') as syncDatetime
                FROM transactions t
                INNER JOIN bank_accounts ba ON t.bankAccountId = ba.id
                INNER JOIN banks b ON ba.bankId = b.id
                WHERE b.id = :bankId
                GROUP BY ba.accountName, syncDatetime 
            """)
    suspend fun getBalanceBy(bankId: Int): List<Balance>
}