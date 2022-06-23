package academy.mukandrew.randm.remote.graphql

import academy.mukandrew.randm.remote.BuildConfig
import com.apollographql.apollo.ApolloClient

class ApolloService {
    private var apolloClient: ApolloClient? = null

    fun getClient(): ApolloClient {
        return apolloClient ?: ApolloClient.builder()
            .serverUrl(BuildConfig.BASE_URL)
            .build()
            .also { apolloClient = it }
    }
}
