package academy.mukandrew.randm.cache.characters.datasource

import academy.mukandrew.randm.cache.characters.daos.CharacterDao
import academy.mukandrew.randm.cache.characters.daos.CharacterSearchPageDao
import academy.mukandrew.randm.cache.characters.mappers.toCharacterEntity
import academy.mukandrew.randm.cache.characters.mappers.toEntity
import academy.mukandrew.randm.cache.characters.mappers.toResponse
import academy.mukandrew.randm.common.exceptions.NoContentException
import academy.mukandrew.randm.data.characters.datasource.CharacterCacheDataSource
import academy.mukandrew.randm.data.characters.models.CharacterFilterRequestInterface
import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.data.pagination.models.InfoPageResponseInterface
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface
import javax.inject.Inject

internal class CharacterLocalDataSource @Inject constructor(
    private val characterDao: CharacterDao,
    private val characterSearchPageDao: CharacterSearchPageDao
) : CharacterCacheDataSource {
    override suspend fun saveCharacter(character: List<CharacterResponseInterface>): List<Long> {
        return characterDao.insert(*character.map { it.toEntity() }.toTypedArray())
    }

    override suspend fun saveSearchPage(
        searchPage: CharacterFilterRequestInterface,
        infoPage: InfoPageResponseInterface,
        pageNumber: Int,
        charactersId: List<Long>
    ) {
        val searchPageId = characterSearchPageDao.insert(searchPage.toEntity())
        characterSearchPageDao.insertPageNumber(
            infoPage.toCharacterEntity(searchPageId, pageNumber, charactersId)
        )
    }

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
        ids: List<Long>
    ): List<CharacterResponseInterface> {
        val response = characterDao.getCharactersById(ids)

        if (response.isEmpty()) throw NoContentException()

        return response
    }
}
