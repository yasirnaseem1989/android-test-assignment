package com.example.shacklehotelbuddy.domain

import com.example.shacklehotelbuddy.domain.Failure.NetworkConnection
import timber.log.Timber
import java.net.UnknownHostException

object FailureFactory {

    fun create(ex: Throwable): Failure {
        val failure = when (ex) {
            is UnknownHostException -> NetworkConnection
            else -> UnknownFailure
        }
        Timber.d("[${ex.javaClass.simpleName}] -> [$failure]")
        return failure
    }
}
