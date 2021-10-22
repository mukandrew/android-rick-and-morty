package academy.mukandrew.randm.data.characters.repository

import academy.mukandrew.randm.common.result.Answer
import academy.mukandrew.randm.data.characters.datasource.CharacterDataSource
import academy.mukandrew.randm.data.characters.mappers.toDomainModel
import academy.mukandrew.randm.data.characters.mappers.toMap
import academy.mukandrew.randm.data.pagination.mappers.toDomainModel
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.models.CharacterFilter
import academy.mukandrew.randm.domain.characters.repository.CharacterRepository
import academy.mukandrew.randm.domain.pagination.models.PageResult

class CharacterRepositoryImpl(
    private val localDataSource: CharacterDataSource,
    private val remoteDataSource: CharacterDataSource
) : CharacterRepository {
    override suspend fun getCharacterList(
        page: Int,
        filter: CharacterFilter
    ): Answer<PageResult<Character>> {
        return try {
            // TODO: offline first

            val response = remoteDataSource.getCharacterList(page, filter.toMap())
            Answer.success(
                response.toDomainModel(response.results::toDomainModel)
            )
        } catch (e: Exception) {
            Answer.failure(e)
        }
    }

    override suspend fun getCharacterById(id: Int): Answer<Character> {
        TODO("Not yet implemented")
    }

    override suspend fun getMultipleCharactersById(ids: List<Int>): Answer<List<Character>> {
        TODO("Not yet implemented")
    }
}