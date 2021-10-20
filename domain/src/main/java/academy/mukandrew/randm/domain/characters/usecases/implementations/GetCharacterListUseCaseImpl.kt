package academy.mukandrew.randm.domain.characters.usecases.implementations

import academy.mukandrew.randm.common.result.Answer
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.models.CharacterFilter
import academy.mukandrew.randm.domain.characters.repository.CharacterRepository
import academy.mukandrew.randm.domain.characters.usecases.abstractions.GetCharacterListUseCase
import academy.mukandrew.randm.domain.common.exceptions.NoContentException
import academy.mukandrew.randm.domain.pagination.models.PageResult

class GetCharacterListUseCaseImpl(
    private val repository: CharacterRepository
) : GetCharacterListUseCase() {

    override suspend fun invoke(
        pageNumber: Int,
        filter: CharacterFilter
    ): Answer<PageResult<Character>> {
        val answer = repository.getCharacterList(pageNumber, filter)

        if (answer.isSuccess && answer.getOrNull()?.results?.isEmpty() == true) {
            return Answer.failure(NoContentException())
        }

        return answer
    }
}
