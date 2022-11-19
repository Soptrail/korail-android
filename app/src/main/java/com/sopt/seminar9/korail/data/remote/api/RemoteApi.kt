package com.sopt.seminar9.korail.data.remote.api

import com.sopt.seminar9.korail.data.remote.model.response.SampleResponse
import retrofit2.Call
import retrofit2.http.GET

interface RemoteApi {
    //Sample API
    @GET("/sample")
    fun getList(): Call<SampleResponse>
}