package com.sopt.seminar9.korail.presentation.ui.book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt.seminar9.korail.R
import com.sopt.seminar9.korail.databinding.FragmentBookTicketBinding
import com.sopt.seminar9.korail.presentation.common.binding.BindingFragment

class BookTicketFragment : BindingFragment<FragmentBookTicketBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBookTicketBinding {
        return FragmentBookTicketBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}