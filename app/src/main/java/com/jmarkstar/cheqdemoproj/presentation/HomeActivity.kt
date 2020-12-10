package com.jmarkstar.cheqdemoproj.presentation

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.common.BaseActivity
import com.jmarkstar.cheqdemoproj.databinding.ActivityHomeBinding
import com.jmarkstar.cheqdemoproj.presentation.home.CardItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //As OWASP suggestion and in case of this app, probably we don't want to allow the user to take screenshots of the app
        // or show the preview in the recent apps.
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)

        val card = CardItem("All accounts","","$1,005","$450","$1445", "4hrs ago", true)
        //val card = CardItem("Commbank","ic_commbank","$149","$0","$149", "Just now", false)
        //binding.cardItem = card
        //binding.bankIcon.setImageDrawable(this.getDrawableByName(card.bankIcon))
        homeViewModel.balances.observe(this, {

        })

        homeViewModel.expenses.observe(this, {

        })
    }
}