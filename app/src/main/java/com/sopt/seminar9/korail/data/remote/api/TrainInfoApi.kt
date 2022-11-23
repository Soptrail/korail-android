package com.sopt.seminar9.korail.data.remote.api

import com.sopt.seminar9.korail.data.remote.model.response.TrainInfoResponse
import retrofit2.Call
import retrofit2.http.GET

interface TrainInfoApi {
    @GET("trail/1")
    fun getList(): Call<TrainInfoResponse>
}