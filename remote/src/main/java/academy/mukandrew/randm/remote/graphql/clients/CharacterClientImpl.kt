package academy.mukandrew.randm.remote.graphql.clients

import academy.mukandrew.randm.remote.CharacterQuery
import academy.mukandrew.randm.remote.CharactersByIdsQuery
import academy.mukandrew.randm.remote.CharactersQuery
import academy.mukandrew.randm.remote.common.awaitDataOrException
import academy.mukandrew.randm.remote.graphql.ApolloService
import javax.inject.Inject

class CharacterClientImpl @Inject constructor(
    private val service: ApolloService
) : CharacterClient {
    override suspend fun getCharacterList(
        query: CharactersQuery
    ): CharactersQuery.Data {
        return service.getClient().query(query).awaitDataOrException()
    }

    override suspend fun getCharacter(
        query: CharacterQuery
    ): CharacterQuery.Data {
        return service.getClient().query(query).awaitDataOrException()
    }

    override suspend fun getCharactersByIds(
        query: CharactersByIdsQuery
    ): CharactersByIdsQuery.Data {
        return service.getClient().query(query).awaitDataOrException()
    }
}
