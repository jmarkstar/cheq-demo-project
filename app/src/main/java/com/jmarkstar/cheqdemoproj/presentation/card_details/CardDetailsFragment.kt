package com.jmarkstar.cheqdemoproj.presentation.card_details

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.common.presentation.BaseFragment
import com.jmarkstar.cheqdemoproj.databinding.FragmentCardDetailsBinding
import com.jmarkstar.cheqdemoproj.presentation.HomeActivity
import com.jmarkstar.cheqdemoproj.presentation.home.HomeViewModel
import timber.log.Timber

class CardDetailsFragment : BaseFragment<FragmentCardDetailsBinding>() {

    private val args by navArgs<CardDetailsFragmentArgs>()

    private val viewModel by lazy { obtainSharedViewModel<HomeViewModel>() }

    override fun layoutId() = R.layout.fragment_card_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.v("homeViewModel are the same: ${viewModel == (requireActivity() as HomeActivity).homeViewModel}")
        sharedElementEnterTransition =
            TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
        postponeEnterTransition()
        binding.apply {
            cardItem = args.selectCardItem
        }
        scheduleStartPostponedTransition(binding.balanceCardView)
    }

    private fun scheduleStartPostponedTransition(sharedElement: View) {
        sharedElement.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    sharedElement.viewTreeObserver.removeOnPreDrawListener(this)
                    startPostponedEnterTransition()
                    return true
                }
            }
        )
    }
}
