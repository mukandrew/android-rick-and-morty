package academy.mukandrew.randm.remote.common

import academy.mukandrew.randm.common.exceptions.NoContentException
import com.apollographql.apollo.ApolloQueryCall
import com.apollographql.apollo.coroutines.await

suspend fun <T> ApolloQueryCall<T>.awaitDataOrException(): T {
    val response = await()
    if (response.hasErrors()) {
        throw Exception(response.errors?.firstOrNull()?.message)
    }

    return response.data ?: throw NoContentException()
}
