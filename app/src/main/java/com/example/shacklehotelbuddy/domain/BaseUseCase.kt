package com.example.shacklehotelbuddy.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber

abstract class BaseUseCase<in Params, out Type>(private val coroutineDispatcher: CoroutineDispatcher) where Type : Any {

    abstract suspend fun execute(params: Params): ShackleResult<Failure, Type>

    protected open suspend fun handleError(ex: Exception): Failure = FailureFactory.create(ex)

    suspend operator fun invoke(params: Params): ShackleResult<Failure, Type> =
        withContext(coroutineDispatcher) {
            try {
                val result = execute(params).also { log(it) }
                return@withContext result
            } catch (ex: Exception) {
                Timber.e(ex)
                val failure = handleError(ex)
                return@withContext ShackleResult.Error(failure)
            }
        }

    private fun log(photosResult: ShackleResult<Failure, Type>) {
        Timber.tag(TAG).d("${this.javaClass.simpleName}=$photosResult")
    }

    private companion object {
        private const val TAG = "USECASE_RESULT"
    }
}

suspend operator fun <R : Any> BaseUseCase<Unit, R>.invoke(): ShackleResult<Failure, R> =
    this(Unit)
