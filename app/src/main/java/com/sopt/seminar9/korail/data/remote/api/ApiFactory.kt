package com.sopt.seminar9.korail.data.remote.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sopt.seminar9.korail.data.remote.model.response.TrainInfoResponse
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiFactory {
    private val client by lazy {
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).build()
    }

    private const val BASE_URL = "http://43.200.249.186:3000/"
    val retrofit_show_train: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(client)
            .build()
    }

    inline fun <reified T> create(): T = retrofit_show_train.create<T>(T::class.java)
}

object ApiPool {
    val remoteApi = ApiFactory.create<RemoteApi>()
    val trainInfoApi = ApiFactory.create<TrainInfoApi>()
}