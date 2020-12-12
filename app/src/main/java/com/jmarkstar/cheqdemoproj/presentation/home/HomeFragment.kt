package com.jmarkstar.cheqdemoproj.presentation.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.common.presentation.BaseFragment
import com.jmarkstar.cheqdemoproj.common.presentation.custom_views.BalanceCardView
import com.jmarkstar.cheqdemoproj.common.presentation.recyclerview.OnRecyclerItemClick
import com.jmarkstar.cheqdemoproj.databinding.FragmentHomeBinding
import com.jmarkstar.cheqdemoproj.presentation.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun layoutId() = R.layout.fragment_home

    private val viewModel by lazy { obtainSharedViewModel<HomeViewModel>() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val snapHelper = PagerSnapHelper()

        Timber.v("homeViewModel are the same: ${viewModel == (requireActivity() as HomeActivity).homeViewModel}")
        binding.apply {
            viewModel = this@HomeFragment.viewModel
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
