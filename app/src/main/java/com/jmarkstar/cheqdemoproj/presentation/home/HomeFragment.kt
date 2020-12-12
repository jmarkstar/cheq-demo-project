package com.jmarkstar.cheqdemoproj.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.common.presentation.BaseFragment
import com.jmarkstar.cheqdemoproj.common.presentation.custom_views.BalanceCardView
import com.jmarkstar.cheqdemoproj.common.presentation.recyclerview.OnRecyclerItemClick
import com.jmarkstar.cheqdemoproj.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

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

            onItemClick = OnRecyclerItemClick { item, view ->
                val cardItem = item.data as CardItem
                val itemView = view as BalanceCardView
                val action =
                    HomeFragmentDirections.actionHomeCardDetails(cardItem, cardItem.bankName)
                val fragmentNavExtras = FragmentNavigatorExtras(itemView to "balanceCardItem")
                findNavController().navigate(action, fragmentNavExtras)
            }
        }
    }
}
