package com.sopt.seminar9.korail.data.remote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class TrainInfoResponse(
    val status: Int,
    val message: String,
    val data: Show_Train_Info
)

@Serializable
data class Show_Train_Info(
    val Departures: String,
    val Arrivals: String,
    val StartDate: String,
    val TrainInformation: List<Show_Train>
)

@Serializable
data class Show_Train(
    val TrainName: String,
    val StartTime: String,
    val LastTime: String,
    val NormalPrice: String,
    val SpecialPrice: String
)