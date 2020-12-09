package com.jmarkstar.cheqdemoproj.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //As OWASP suggestion and in case of this app, probably we don't want to allow the user to take screenshots of the app
        // or show the preview in the recent apps.
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        homeViewModel.balances.observe(this, {
            binding.balanceCount = "${it.size}"
        })

        homeViewModel.expenses.observe(this, {

        })
    }
}