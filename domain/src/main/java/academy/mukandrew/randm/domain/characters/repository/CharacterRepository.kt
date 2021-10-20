package academy.mukandrew.randm.domain.characters.repository

import academy.mukandrew.randm.common.result.Answer
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.models.CharacterFilter
import academy.mukandrew.randm.domain.pagination.models.PageResult

interface CharacterRepository {
    fun getCharacterList(page: Int, filter: CharacterFilter): Answer<PageResult<Character>>
    fun getCharacterById(id: Int): Answer<Character>
    fun getMultipleCharactersById(ids: List<Int>): Answer<List<Character>>
}
