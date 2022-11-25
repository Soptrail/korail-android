package com.sopt.seminar9.korail.data.remote.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.seminar9.korail.data.remote.api.ApiPool
import com.sopt.seminar9.korail.data.remote.model.response.Show_Train
import com.sopt.seminar9.korail.data.remote.model.response.Show_Train_Info
import com.sopt.seminar9.korail.data.remote.model.response.TrainInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TrainInfoViewModel: ViewModel() {
        private val trainInfoApi = ApiPool.trainInfoApi
        private val _getResult: MutableLiveData<Show_Train_Info> = MutableLiveData()
        val getResult: LiveData<Show_Train_Info>
            get() = _getResult
        private val _successGet = MutableLiveData<Boolean>()
        val successGet: LiveData<Boolean>
            get() = _successGet
        private val _errorMessage = MutableLiveData<String>()
        val errorMessage: LiveData<String>
            get() = _errorMessage

        fun getList() {
            trainInfoApi.getList().enqueue(object: Callback<TrainInfoResponse> {
                override fun onResponse(
                    call: Call<TrainInfoResponse>,
                    response: Response<TrainInfoResponse>
                ) {
                    when (response.code()) {
                        400 -> {
                            Log.e("400", "error")
                            _successGet.value = false
                        }
                        500 -> {
                            Log.e("500", "error")
                            _successGet.value = false
                        }
                    }
                    if (response.isSuccessful) {
                        Log.e("500", "서버통신 성공")
                        _getResult.value = response.body()?.data
                        _successGet.value = true
                    }
                }

                override fun onFailure(call: Call<TrainInfoResponse>, t: Throwable) {
                    Log.e("server fail", "${t.message.toString()}")
                    _successGet.value = false
                    _errorMessage.value = t.message
                }
            })
        }
    }