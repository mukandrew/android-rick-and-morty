package academy.mukandrew.randm.remote.graphql

import com.apollographql.apollo.ApolloClient

fun getApolloClientInstance(url: String): ApolloClient {
    return ApolloClient.builder()
        .serverUrl(url)
        .build()
}
