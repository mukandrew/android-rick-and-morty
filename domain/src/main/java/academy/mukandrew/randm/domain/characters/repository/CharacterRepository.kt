package academy.mukandrew.randm.domain.characters.repository

import academy.mukandrew.randm.common.result.Answer
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.models.CharacterFilter
import academy.mukandrew.randm.domain.pagination.models.PageResult

interface CharacterRepository {
    suspend fun getCharacterList(page: Int, filter: CharacterFilter): Answer<PageResult<Character>>
    suspend fun getCharacterById(id: Int): Answer<Character>
    suspend fun getMultipleCharactersById(ids: List<Long>): Answer<List<Character>>
}
