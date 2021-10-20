package academy.mukandrew.randm.domain.characters.usecases.abstractions

import academy.mukandrew.randm.common.result.Answer
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.models.CharacterFilter
import academy.mukandrew.randm.domain.pagination.models.PageResult

abstract class GetCharacterListUseCase {
    abstract suspend operator fun invoke(
        pageNumber: Int,
        filter: CharacterFilter = CharacterFilter.empty()
    ): Answer<PageResult<Character>>
}
