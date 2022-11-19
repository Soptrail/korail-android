package com.sopt.seminar9.korail.presentation.ui.discount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt.seminar9.korail.databinding.FragmentDiscountTicketBinding
import com.sopt.seminar9.korail.presentation.common.binding.BindingFragment

class DiscountTicketFragment : BindingFragment<FragmentDiscountTicketBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDiscountTicketBinding {
        return FragmentDiscountTicketBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}