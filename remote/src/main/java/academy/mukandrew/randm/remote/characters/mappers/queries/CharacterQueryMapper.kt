package academy.mukandrew.randm.remote.characters.mappers.queries

import academy.mukandrew.randm.remote.CharacterQuery

fun getCharacterQuery(id: Int): CharacterQuery {
    return CharacterQuery(id.toString())
}
