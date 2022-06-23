package academy.mukandrew.randm.data.characters.repository

import academy.mukandrew.randm.common.result.Answer
import academy.mukandrew.randm.common.utils.answerBy
import academy.mukandrew.randm.data.characters.datasource.CharacterDataSource
import academy.mukandrew.randm.data.characters.di.CharacterLocalDataSourceQualifier
import academy.mukandrew.randm.data.characters.di.CharacterRemoteDataSourceQualifier
import academy.mukandrew.randm.data.characters.mappers.toDomainModel
import academy.mukandrew.randm.data.characters.mappers.toRequest
import academy.mukandrew.randm.data.pagination.mappers.toDomainModel
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.models.CharacterFilter
import academy.mukandrew.randm.domain.characters.repository.CharacterRepository
import academy.mukandrew.randm.domain.pagination.models.PageResult
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    @CharacterLocalDataSourceQualifier private val localDataSource: CharacterDataSource,
    @CharacterRemoteDataSourceQualifier private val remoteDataSource: CharacterDataSource
) : CharacterRepository {
    override suspend fun getCharacterList(
        page: Int,
        filter: CharacterFilter
    ): Answer<PageResult<Character>> {
        val mappedFilter = filter.toRequest()

        return answerBy(
            fromLocal = { localDataSource.getCharacterList(page, mappedFilter) },
            fromRemote = { remoteDataSource.getCharacterList(page, mappedFilter) },
            mapper = { it.toDomainModel(it.results::toDomainModel) }
        )
    }

    override suspend fun getCharacterById(id: Int): Answer<Character> {
        return answerBy(
            fromLocal = { localDataSource.getCharacterById(id) },
            fromRemote = { remoteDataSource.getCharacterById(id) },
            mapper = { it.toDomainModel() }
        )
    }

    override suspend fun getMultipleCharactersById(ids: List<Int>): Answer<List<Character>> {
        return answerBy(
            fromLocal = { localDataSource.getMultipleCharactersById(ids) },
            fromRemote = { remoteDataSource.getMultipleCharactersById(ids) },
            mapper = { response ->
                response.map { it.toDomainModel() }
            }
        )
    }
}
