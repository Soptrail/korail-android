package com.sopt.seminar9.korail.data.remote.datasource

import com.sopt.seminar9.korail.data.remote.model.response.SampleResponse
import retrofit2.Call

interface RemoteDataSource {
    fun getList(): Call<SampleResponse>
}