package com.jmarkstar.cheqdemoproj.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.common.presentation.BaseActivity
import com.jmarkstar.cheqdemoproj.databinding.ActivityHomeBinding
import com.jmarkstar.cheqdemoproj.presentation.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    val homeViewModel by viewModels<HomeViewModel>()

    override fun layoutId() = R.layout.activity_home

    override fun navHostFragment() = R.id.nav_host_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            setupToolbar(toolbar)
        }
    }
}
