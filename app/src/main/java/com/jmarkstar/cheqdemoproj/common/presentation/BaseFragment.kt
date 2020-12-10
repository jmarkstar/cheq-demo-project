package com.jmarkstar.cheqdemoproj.common.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<Binding: ViewDataBinding>: Fragment() {

    lateinit var binding: Binding

    abstract fun layoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) : View {
        binding = DataBindingUtil.inflate(inflater, layoutId() ,container , false)
        return binding.root
    }
}