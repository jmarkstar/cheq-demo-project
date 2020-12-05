package com.jmarkstar.cheqdemoproj.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.repositories.BalanceRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var balanceRepository: BalanceRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            balanceRepository.getBalancesByBank().forEach {
                Timber.v(it.toString())
            }

            balanceRepository.getAllBankAccountsBalance().forEach {
                Timber.v(it.toString())
            }
        }
    }
}