package academy.mukandrew.randm.domain.characters.usecases.abstractions

import academy.mukandrew.randm.common.result.Answer
import academy.mukandrew.randm.domain.characters.models.Character

abstract class GetCharacterUseCase {
    abstract suspend operator fun invoke(id: Int): Answer<Character>
}
