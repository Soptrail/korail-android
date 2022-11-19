package com.sopt.seminar9.korail.presentation.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt.seminar9.korail.data.remote.api.ApiPool
import com.sopt.seminar9.korail.data.remote.datasource.RemoteDataSourceImpl
import com.sopt.seminar9.korail.data.remote.model.response.SampleResponse
import com.sopt.seminar9.korail.data.remote.repository.RemoteRepositoryImpl
import com.sopt.seminar9.korail.databinding.FragmentBookTicketBinding
import com.sopt.seminar9.korail.presentation.common.binding.BindingFragment
import com.sopt.seminar9.korail.presentation.application.KorailApplication
import com.sopt.seminar9.korail.presentation.application.container.AppContainer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookTicketFragment : BindingFragment<FragmentBookTicketBinding>() {
    private lateinit var appContainer: AppContainer

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBookTicketBinding {
        return FragmentBookTicketBinding.inflate(inflater, container, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        appContainer = (KorailApplication.application as KorailApplication).appContainer
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun getList() {
        // TODO: 삭제예정, api 예시
        appContainer.remoteRepository.getList().enqueue(object : Callback<SampleResponse> {
            override fun onResponse(
                call: Call<SampleResponse>,
                response: Response<SampleResponse>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<SampleResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}