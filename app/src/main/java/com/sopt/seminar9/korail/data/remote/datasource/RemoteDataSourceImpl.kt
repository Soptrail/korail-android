package com.sopt.seminar9.korail.data.remote.datasource

import com.sopt.seminar9.korail.data.remote.api.RemoteApi
import com.sopt.seminar9.korail.data.remote.model.response.SampleResponse
import retrofit2.Call

class RemoteDataSourceImpl(private val remoteApi: RemoteApi): RemoteDataSource {
    override fun getList(): Call<SampleResponse> = remoteApi.getList()
}