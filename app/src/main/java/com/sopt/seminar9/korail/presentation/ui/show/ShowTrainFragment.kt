package com.sopt.seminar9.korail.presentation.ui.tour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt.seminar9.korail.databinding.FragmentDiscountTicketBinding
import com.sopt.seminar9.korail.databinding.FragmentShowTrainBinding
import com.sopt.seminar9.korail.databinding.FragmentTourProductBinding
import com.sopt.seminar9.korail.presentation.common.binding.BindingFragment

class ShowTrainFragment : BindingFragment<FragmentShowTrainBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentShowTrainBinding {
        return FragmentShowTrainBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}