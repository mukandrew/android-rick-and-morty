package academy.mukandrew.randm.remote.characters.datasource

import academy.mukandrew.randm.data.characters.datasource.CharacterDataSource
import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface
import academy.mukandrew.randm.remote.characters.clients.CharacterClient
import academy.mukandrew.randm.remote.characters.mappers.queries.getCharacterQuery
import academy.mukandrew.randm.remote.characters.mappers.queries.getCharactersByIdsQuery
import academy.mukandrew.randm.remote.characters.mappers.queries.getCharactersQuery
import academy.mukandrew.randm.remote.characters.mappers.responses.toResponseModel

class CharacterRemoteDataSource(
    private val client: CharacterClient
) : CharacterDataSource {
    override suspend fun getCharacterList(
        page: Int,
        filters: Map<String, String>
    ): PageResultResponseInterface<CharacterResponseInterface> {
        return client.getCharacterList(getCharactersQuery(page, filters)).toResponseModel()
    }

    override suspend fun getCharacterById(id: Int): CharacterResponseInterface {
        return client.getCharacter(getCharacterQuery(id)).toResponseModel()
    }

    override suspend fun getMultipleCharactersById(
        ids: List<Int>
    ): List<CharacterResponseInterface> {
        return client.getCharactersByIds(getCharactersByIdsQuery(ids)).toResponseModel()
    }
}
