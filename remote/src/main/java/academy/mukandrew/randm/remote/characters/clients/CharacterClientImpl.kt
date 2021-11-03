package academy.mukandrew.randm.remote.characters.clients

import academy.mukandrew.randm.remote.CharacterQuery
import academy.mukandrew.randm.remote.CharactersByIdsQuery
import academy.mukandrew.randm.remote.CharactersQuery
import academy.mukandrew.randm.remote.common.awaitDataOrException
import com.apollographql.apollo.ApolloClient

class CharacterClientImpl(
    private val client: ApolloClient
) : CharacterClient {
    override suspend fun getCharacterList(
        query: CharactersQuery
    ): CharactersQuery.Data {
        return client.query(query).awaitDataOrException()
    }

    override suspend fun getCharacter(
        query: CharacterQuery
    ): CharacterQuery.Data {
        return client.query(query).awaitDataOrException()
    }

    override suspend fun getCharactersByIds(
        query: CharactersByIdsQuery
    ): CharactersByIdsQuery.Data {
        return client.query(query).awaitDataOrException()
    }
}
