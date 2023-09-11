package com.example.shacklehotelbuddy.domain

import com.example.shacklehotelbuddy.domain.ShackleResult.Error
import com.example.shacklehotelbuddy.domain.ShackleResult.Success


sealed class ShackleResult<out Failure, out Data> {

    data class Error<out Failure>(val errorData: Failure) : ShackleResult<Failure, Nothing>()
    data class Success<out Data>(val data: Data) : ShackleResult<Nothing, Data>()

    val isSuccess get() = this is Success<Data>
    val isError get() = this is Error<Failure>

    fun result(onError: (Failure) -> Unit = {}, onSuccess: (Data) -> Unit = {}): Any =
        when (this) {
            is Error -> onError(errorData)
            is Success -> onSuccess(data)
        }
}

fun <OldType, Failure, NewType> ShackleResult<Failure, OldType>.map(
    transform: (OldType) -> NewType
): ShackleResult<Failure, NewType> {
    return when (this) {
        is Success -> Success(transform(data))
        is Error -> this
    }
}

fun <OldType, Failure, NewType> ShackleResult<Failure, OldType>.flatMap(
    transform: (OldType) -> ShackleResult<Failure, NewType>
): ShackleResult<Failure, NewType> {
    return when (this) {
        is Success -> transform(data)
        is Error -> this
    }
}
