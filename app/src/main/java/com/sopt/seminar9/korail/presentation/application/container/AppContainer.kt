package com.sopt.seminar9.korail.presentation.application.container

import com.sopt.seminar9.korail.data.remote.api.ApiPool
import com.sopt.seminar9.korail.data.remote.datasource.RemoteDataSourceImpl
import com.sopt.seminar9.korail.data.remote.repository.RemoteRepositoryImpl

class AppContainer {
    private val remoteDataSourceImpl = RemoteDataSourceImpl(ApiPool.remoteApi)
    val remoteRepository = RemoteRepositoryImpl(remoteDataSourceImpl)
}