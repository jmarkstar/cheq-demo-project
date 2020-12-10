package com.jmarkstar.cheqdemoproj.presentation

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.PagerSnapHelper
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.presentation.common.BaseActivity
import com.jmarkstar.cheqdemoproj.databinding.ActivityHomeBinding
import com.jmarkstar.cheqdemoproj.presentation.common.recyclerview.CardItemDecoration
import com.jmarkstar.cheqdemoproj.presentation.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //As OWASP suggestion and in case of this app, probably we don't want to allow the user to take screenshots of the app
        // or show the preview in the recent apps.
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        val snapHelper = PagerSnapHelper()

        DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home).apply {
            viewModel = homeViewModel
            lifecycleOwner = this@HomeActivity

            rvCard.addItemDecoration(CardItemDecoration())
            snapHelper.attachToRecyclerView(rvCard)
        }
    }
}