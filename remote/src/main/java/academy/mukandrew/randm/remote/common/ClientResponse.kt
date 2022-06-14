package academy.mukandrew.randm.remote.common

import academy.mukandrew.randm.common.exceptions.NoContentException
import com.apollographql.apollo.ApolloQueryCall
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloNetworkException

suspend fun <T> ApolloQueryCall<T>.awaitDataOrException(): T {
    val response = await()
    if (response.hasErrors()) {
        throw ApolloNetworkException(response.errors?.firstOrNull()?.message)
    }

    return response.data ?: throw NoContentException()
}
