package academy.mukandrew.randm.common.utils

import academy.mukandrew.randm.common.result.Answer

suspend fun <T> ignoreException(block: suspend () -> T?): T? {
    return try {
        block()
    } catch (e: Exception) {
        null
    }
}

suspend fun <T, O> answerBy(
    fromLocal: suspend () -> O?,
    fromRemote: suspend () -> O,
    mapper: (O) -> T
): Answer<T> {
    return try {
        val response = ignoreException { fromLocal() } ?: fromRemote()
        Answer.success(mapper(response))
    } catch (e: Exception) {
        Answer.failure(e)
    }
}
