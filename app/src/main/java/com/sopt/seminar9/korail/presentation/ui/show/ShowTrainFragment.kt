package com.sopt.seminar9.korail.presentation.ui.tour

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.sopt.seminar9.korail.R
import com.sopt.seminar9.korail.data.remote.dataadapter.TrainInfoAdapter
import com.sopt.seminar9.korail.data.remote.model.response.Show_Train
import com.sopt.seminar9.korail.data.remote.viewmodel.TrainInfoViewModel
import com.sopt.seminar9.korail.databinding.FragmentShowTrainBinding
import com.sopt.seminar9.korail.presentation.common.binding.BindingFragment

class ShowTrainFragment : BindingFragment<FragmentShowTrainBinding>() {
    private val trainInfoViewModel by viewModels<TrainInfoViewModel>()
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentShowTrainBinding {
        return FragmentShowTrainBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // 서버통신으로 리사이클러 뷰에 아이템들 연결해야 함
        super.onViewCreated(view, savedInstanceState)
        returnBackFragment()
        setSpinner()
        binding.showProgressBar.isVisible = true // 로딩뷰 활성화
        trainInfoViewModel.getList()
        trainInfoViewModel.successGet.observe(viewLifecycleOwner){ success ->
            if(success) {
                Log.d("data", trainInfoViewModel.getResult.value.toString())
                val adapter = context?.let { it1 ->
                    trainInfoViewModel.getResult.value?.let {
                        TrainInfoAdapter(trainInfoViewModel.getResult.value!!.TrainInformation, it1).apply {
                            setRepoList(trainInfoViewModel.getResult.value!!.TrainInformation)
                        }
                    }
                }

                binding.txtShowPlaceDepart.text = trainInfoViewModel.getResult.value?.Departures
                binding.txtShowPlaceArrive.text = trainInfoViewModel.getResult.value?.Arrivals
                binding.txtShowDate.text = trainInfoViewModel.getResult.value?.StartDate
                binding.rvTrain.adapter = adapter
                binding.showProgressBar.isVisible = false // 서버통신 완료 -> 로딩뷰 비활성
            }
        }
   }

    private fun setSpinner(){ // Spinner 세팅
        val TrainKind = listOf("전체", "ktx", "무궁화")
        val SeatKind = listOf("일반석", "특/우등석")
        val MoveKind = listOf("직통", "일반") // xml에 저장하는 방법과 변수로 저장하는 방법으로 나뉨

        binding.showSpinnerLeft.adapter = ArrayAdapter(requireContext(), R.layout.item_spinner, TrainKind)
        binding.showSpinnerCenter.adapter = ArrayAdapter(requireContext(), R.layout.item_spinner, SeatKind)
        binding.showSpinnerRight.adapter = ArrayAdapter(requireContext(), R.layout.item_spinner, MoveKind)
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