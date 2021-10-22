package academy.mukandrew.randm.domain.characters.usecases.implementations

import academy.mukandrew.randm.common.result.Answer
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.repository.CharacterRepository
import academy.mukandrew.randm.domain.characters.usecases.abstractions.GetCharacterUseCase

class GetCharacterUseCaseImpl(
    private val repository: CharacterRepository
) : GetCharacterUseCase() {
    override suspend fun invoke(id: Int): Answer<Character> {
        return repository.getCharacterById(id)
    }
}
