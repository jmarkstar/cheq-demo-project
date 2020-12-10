package com.jmarkstar.cheqdemoproj.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.PagerSnapHelper
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.common.presentation.BaseFragment
import com.jmarkstar.cheqdemoproj.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding>() {

    override fun layoutId() = R.layout.fragment_home

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val snapHelper = PagerSnapHelper()

        binding.apply {
            viewModel = homeViewModel
            lifecycleOwner = this@HomeFragment

            rvCard.addItemDecoration(CardItemDecoration())
            snapHelper.attachToRecyclerView(rvCard)
        }
    }
}