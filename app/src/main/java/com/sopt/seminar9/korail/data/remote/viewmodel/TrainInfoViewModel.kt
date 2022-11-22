package com.sopt.seminar9.korail.data.remote.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.seminar9.korail.data.remote.api.ApiPool
import com.sopt.seminar9.korail.data.remote.model.response.TrainInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TrainInfoViewModel: ViewModel() {
        private val trainInfoApi = ApiPool.trainInfoApi
        private val _getResult: MutableLiveData<TrainInfoResponse> = MutableLiveData()
        val getResult: LiveData<TrainInfoResponse>
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
                        _getResult.value = response.body()
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