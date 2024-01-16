package academy.mukandrew.randm.remote.common

import academy.mukandrew.randm.common.exceptions.NoContentException
import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.api.Operation.Data
import com.apollographql.apollo3.exception.ApolloNetworkException

suspend fun <T : Data> ApolloCall<T>.awaitDataOrException(): T {
    val response = execute()
    if (response.hasErrors()) {
        throw ApolloNetworkException(response.errors?.firstOrNull()?.message)
    }

    return response.data ?: throw NoContentException()
}
