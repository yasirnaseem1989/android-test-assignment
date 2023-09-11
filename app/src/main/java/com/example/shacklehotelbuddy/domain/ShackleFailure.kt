package com.example.shacklehotelbuddy.domain

import com.example.shacklehotelbuddy.utils.AppConstants.EMPTY_STRING


sealed class ShackleFailure(val message: String?) : Failure.FeatureFailure()
data class EOFFailure(val errorMessage: String?) : ShackleFailure(errorMessage)
data class NetworkFailure(val errorMessage: String?) : ShackleFailure(errorMessage)
data class HttpFailure(val ex: Exception) : ShackleFailure(ex.message)
object EmptyResponseFailure : ShackleFailure(EMPTY_STRING)
object UnknownFailure : ShackleFailure(EMPTY_STRING)
object NullResponseFailure : ShackleFailure(EMPTY_STRING)
data class ShackleServerFailure(val errorMessage: String?) : ShackleFailure(errorMessage)