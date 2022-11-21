package com.sopt.seminar9.korail.presentation.ui.check

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt.seminar9.korail.databinding.FragmentCheckTicketBinding
import com.sopt.seminar9.korail.presentation.common.binding.BindingFragment


class CheckTicketFragment : BindingFragment<FragmentCheckTicketBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCheckTicketBinding {
        return FragmentCheckTicketBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}