package com.sopt.seminar9.korail.data.remote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class SampleResponse(
  val breeds: List<String>?,
  val id: Int,
) {
  companion object {
    fun emptyResponse() = SampleResponse(listOf(), -1)
  }
}