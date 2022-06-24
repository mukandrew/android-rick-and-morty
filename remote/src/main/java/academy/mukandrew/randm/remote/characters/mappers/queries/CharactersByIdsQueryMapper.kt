package academy.mukandrew.randm.remote.characters.mappers.queries

import academy.mukandrew.randm.remote.CharactersByIdsQuery

fun getCharactersByIdsQuery(ids: List<Long>): CharactersByIdsQuery {
    return CharactersByIdsQuery(ids.map { it.toString() })
}
