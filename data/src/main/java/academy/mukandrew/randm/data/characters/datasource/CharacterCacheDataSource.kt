package academy.mukandrew.randm.data.characters.datasource

import academy.mukandrew.randm.data.characters.models.CharacterFilterRequestInterface
import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.data.pagination.models.InfoPageResponseInterface

interface CharacterCacheDataSource : CharacterDataSource {
    suspend fun saveCharacter(character: List<CharacterResponseInterface>): List<Long>

    suspend fun saveSearchPage(
        searchPage: CharacterFilterRequestInterface,
        infoPage: InfoPageResponseInterface,
        pageNumber: Int,
        charactersId: List<Long>
    )
}
