package academy.mukandrew.randm.cache.characters.datasource

import academy.mukandrew.randm.cache.characters.daos.CharacterDao
import academy.mukandrew.randm.cache.characters.daos.CharacterSearchPageDao
import academy.mukandrew.randm.cache.characters.mappers.toResponse
import academy.mukandrew.randm.common.exceptions.NoContentException
import academy.mukandrew.randm.data.characters.datasource.CharacterDataSource
import academy.mukandrew.randm.data.characters.models.CharacterFilterRequestInterface
import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface

internal class CharacterLocalDataSource(
    private val characterDao: CharacterDao,
    private val characterSearchPageDao: CharacterSearchPageDao
) : CharacterDataSource {
    override suspend fun getCharacterList(
        page: Int,
        filters: CharacterFilterRequestInterface
    ): PageResultResponseInterface<CharacterResponseInterface> {
        val searchPage = characterSearchPageDao.getSearchPage(
            filters.name,
            filters.status,
            filters.species,
            filters.type,
            filters.gender,
            page
        ) ?: throw NoContentException()

        val characters = characterDao.getCharactersById(searchPage.characterIds)

        return searchPage.toResponse(characters)
    }

    override suspend fun getCharacterById(id: Int): CharacterResponseInterface? {
        return characterDao.getCharacterById(id).firstOrNull()
    }

    override suspend fun getMultipleCharactersById(
        ids: List<Int>
    ): List<CharacterResponseInterface> {
        val response = characterDao.getCharactersById(ids)

        if (response.isEmpty()) throw NoContentException()

        return response
    }
}
