package com.jmarkstar.cheqdemoproj.presentation.card_details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.common.presentation.BaseFragment
import com.jmarkstar.cheqdemoproj.databinding.FragmentCardDetailsBinding

class CardDetailsFragment: BaseFragment<FragmentCardDetailsBinding>() {

    private val args by navArgs<CardDetailsFragmentArgs>()

    override fun layoutId() = R.layout.fragment_card_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedElementEnterTransition = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
        binding.apply {
            cardItem = args.selectCardItem
        }
    }

}