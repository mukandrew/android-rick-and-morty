package academy.mukandrew.randm.data.characters.repository

import academy.mukandrew.randm.common.result.Answer
import academy.mukandrew.randm.data.characters.datasource.CharacterDataSource
import academy.mukandrew.randm.data.characters.mappers.toDomainModel
import academy.mukandrew.randm.data.characters.mappers.toMap
import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.data.pagination.mappers.toDomainModel
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.models.CharacterFilter
import academy.mukandrew.randm.domain.characters.repository.CharacterRepository
import academy.mukandrew.randm.domain.common.exceptions.NoContentException
import academy.mukandrew.randm.domain.pagination.models.PageResult

class CharacterRepositoryImpl(
    private val localDataSource: CharacterDataSource,
    private val remoteDataSource: CharacterDataSource
) : CharacterRepository {
    override suspend fun getCharacterList(
        page: Int,
        filter: CharacterFilter
    ): Answer<PageResult<Character>> {
        val mappedFilter = filter.toMap()
        var response: PageResultResponseInterface<CharacterResponseInterface>? = try {
            localDataSource.getCharacterList(page, mappedFilter)
        } catch (e: Exception) {
            null
        }

        return try {
            if (response == null || response.results.isNullOrEmpty()) {
                response = remoteDataSource.getCharacterList(page, mappedFilter)
            }
            Answer.success(response.toDomainModel(response.results::toDomainModel))
        } catch (e: Exception) {
            Answer.failure(e)
        }
    }

    override suspend fun getCharacterById(id: Int): Answer<Character> {
        var response: CharacterResponseInterface? = try {
            localDataSource.getCharacterById(id)
        } catch (e: Exception) {
            null
        }

        return try {
            if (response == null) {
                response = remoteDataSource.getCharacterById(id) ?: run {
                    return Answer.failure(NoContentException())
                }
            }
            Answer.success(response.toDomainModel())
        } catch (e: Exception) {
            Answer.failure(e)
        }
    }

    override suspend fun getMultipleCharactersById(ids: List<Int>): Answer<List<Character>> {
        var response: List<CharacterResponseInterface> = try {
            localDataSource.getMultipleCharactersById(ids)
        } catch (e: Exception) {
            emptyList()
        }

        return try {
            if (response.isEmpty()) {
                response = remoteDataSource.getMultipleCharactersById(ids)
            }
            Answer.success(response.map { it.toDomainModel() })
        } catch (e: Exception) {
            Answer.failure(e)
        }
    }
}
