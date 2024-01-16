package academy.mukandrew.randm.remote.graphql

import com.apollographql.apollo3.ApolloClient

class ApolloService {
    private var apolloClient: ApolloClient? = null

    fun getClient(): ApolloClient {
        return apolloClient ?: ApolloClient.Builder()
            .serverUrl(BASE_URL)
            .build()
            .also { apolloClient = it }
    }

    private companion object {
        private const val BASE_URL = "https://rickandmortyapi.com/graphql"
    }
}
