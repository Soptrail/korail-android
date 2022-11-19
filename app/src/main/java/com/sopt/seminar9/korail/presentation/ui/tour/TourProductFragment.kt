package com.sopt.seminar9.korail.presentation.ui.tour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt.seminar9.korail.databinding.FragmentDiscountTicketBinding
import com.sopt.seminar9.korail.databinding.FragmentTourProductBinding
import com.sopt.seminar9.korail.presentation.common.binding.BindingFragment

class TourProductFragment : BindingFragment<FragmentTourProductBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTourProductBinding {
        return FragmentTourProductBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}