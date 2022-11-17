package com.sopt.seminar9.korail.data.remote.repository

import com.sopt.seminar9.korail.data.remote.datasource.RemoteDataSource
import com.sopt.seminar9.korail.data.remote.model.response.SampleResponse
import retrofit2.Call

class RemoteRepositoryImpl(private val remoteDataSource: RemoteDataSource) : RemoteRepository {
    override fun getList(): Call<SampleResponse> = remoteDataSource.getList()
}