package com.sopt.seminar9.korail.presentation.ui.tour

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.sopt.seminar9.korail.data.remote.viewmodel.TrainInfoViewModel
import com.sopt.seminar9.korail.databinding.FragmentShowTrainBinding
import com.sopt.seminar9.korail.presentation.common.binding.BindingFragment

class ShowTrainFragment : BindingFragment<FragmentShowTrainBinding>() {
    private val homeViewmodel by viewModels<TrainInfoViewModel>()
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentShowTrainBinding {
        return FragmentShowTrainBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // 서버통신으로 리사이클러 뷰에 아이템들 연결해야 함
        super.onViewCreated(view, savedInstanceState)
        returnBackFragment()
        binding.showProgressBar.isVisible = true // 로딩뷰 활성화
        homeViewmodel.getList()
        /*homeViewmodel.successGet.observe(viewLifecycleOwner){ success ->
            if(success){
                Log.d(homeViewmodel.getResult.value?.data.toString(), "data")
                val adapter = context?.let { it1 ->
                    homeViewmodel.getResult.value?.let {
                        TrainInfoadapter(homeViewmodel.getResult.value!!.data, it1).apply {
                            Log.d(homeViewmodel.getResult.value!!.toString(), "data")
                            setRepoList(homeViewmodel.getResult.value!!.data)
                        }
                    }
                }
                binding.rvRepos.adapter = adapter
                binding.showProgressBar.isVisible = false // 서버통신 완료 -> 로딩뷰 비활성화
            }*/
       // }

    }

    private fun dataToView(){

    }

    private fun returnBackFragment() // 뒤로가기 버튼 클릭 시 직전 fragment로 이동
    {
        binding.showBackButtonTop.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    companion object {
        fun newInstance(): ShowTrainFragment {
            return ShowTrainFragment()
        }
    }
}