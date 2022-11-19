package com.sopt.seminar9.korail.data.remote.repository

import com.sopt.seminar9.korail.data.remote.model.response.SampleResponse
import retrofit2.Call

interface RemoteRepository {
    fun getList(): Call<SampleResponse>
}