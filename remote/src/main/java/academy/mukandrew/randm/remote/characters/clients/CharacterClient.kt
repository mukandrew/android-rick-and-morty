package academy.mukandrew.randm.remote.characters.clients

import academy.mukandrew.randm.remote.CharacterQuery
import academy.mukandrew.randm.remote.CharactersByIdsQuery
import academy.mukandrew.randm.remote.CharactersQuery

interface CharacterClient {
    suspend fun getCharacterList(query: CharactersQuery): CharactersQuery.Data
    suspend fun getCharacter(query: CharacterQuery): CharacterQuery.Data
    suspend fun getCharactersByIds(query: CharactersByIdsQuery): CharactersByIdsQuery.Data
}