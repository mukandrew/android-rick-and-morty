package academy.mukandrew.randm.data.characters.datasource

import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface

interface CharacterDataSource {
    suspend fun getCharacterList(
        page: Int,
        filters: Map<String, String>
    ): PageResultResponseInterface<CharacterResponseInterface>

    suspend fun getCharacterById(id: Int): CharacterResponseInterface?
    suspend fun getMultipleCharactersById(ids: List<Int>): List<CharacterResponseInterface>
}
