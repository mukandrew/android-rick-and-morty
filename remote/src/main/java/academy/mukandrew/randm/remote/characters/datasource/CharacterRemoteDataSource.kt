package academy.mukandrew.randm.remote.characters.datasource

import academy.mukandrew.randm.data.characters.datasource.CharacterDataSource
import academy.mukandrew.randm.data.characters.models.CharacterFilterRequestInterface
import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface
import academy.mukandrew.randm.remote.characters.mappers.queries.getCharacterQuery
import academy.mukandrew.randm.remote.characters.mappers.queries.getCharactersByIdsQuery
import academy.mukandrew.randm.remote.characters.mappers.queries.getCharactersQuery
import academy.mukandrew.randm.remote.characters.mappers.responses.toResponseModel
import academy.mukandrew.randm.remote.graphql.clients.CharacterClient
import javax.inject.Inject

class CharacterRemoteDataSource @Inject constructor(
    private val client: CharacterClient
) : CharacterDataSource {
    override suspend fun getCharacterList(
        page: Int,
        filters: CharacterFilterRequestInterface
    ): PageResultResponseInterface<CharacterResponseInterface> {
        return client.getCharacterList(filters.getCharactersQuery(page)).toResponseModel()
    }

    override suspend fun getCharacterById(id: Int): CharacterResponseInterface {
        return client.getCharacter(getCharacterQuery(id)).toResponseModel()
    }

    override suspend fun getMultipleCharactersById(
        ids: List<Long>
    ): List<CharacterResponseInterface> {
        return client.getCharactersByIds(getCharactersByIdsQuery(ids)).toResponseModel()
    }
}
