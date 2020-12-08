package com.jmarkstar.cheqdemoproj.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.repositories.BalanceRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var balanceRepository: BalanceRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //As OWASP suggestions and in case of this app, probably we don't want to allow the user to take screenshots of the app
        // or show the preview in the recent apps.
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        setContentView(R.layout.activity_main)

        GlobalScope.launch {

            val balanceCount = balanceRepository.getBalancesByBank().size

            runOnUiThread {
                tvBalanceCount.text = "$balanceCount"
            }
        }
    }
}