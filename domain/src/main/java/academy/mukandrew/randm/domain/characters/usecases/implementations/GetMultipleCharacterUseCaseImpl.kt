package academy.mukandrew.randm.domain.characters.usecases.implementations

import academy.mukandrew.randm.common.exceptions.NoContentException
import academy.mukandrew.randm.common.result.Answer
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.repository.CharacterRepository
import academy.mukandrew.randm.domain.characters.usecases.abstractions.GetMultipleCharacterUseCase

class GetMultipleCharacterUseCaseImpl(
    private val repository: CharacterRepository
) : GetMultipleCharacterUseCase() {
    override suspend fun invoke(ids: List<Int>): Answer<List<Character>> {
        val answer = repository.getMultipleCharactersById(ids)

        if (answer.isSuccess && answer.getOrNull()?.isEmpty() == true) {
            return Answer.failure(NoContentException())
        }

        return answer
    }
}
