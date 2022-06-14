package academy.mukandrew.randm.remote.characters.mappers.queries

import academy.mukandrew.randm.data.characters.models.CharacterFilterRequestInterface
import academy.mukandrew.randm.remote.CharactersQuery
import academy.mukandrew.randm.remote.type.FilterCharacter
import com.apollographql.apollo.api.Input

internal fun CharacterFilterRequestInterface.getCharactersQuery(
    page: Int
): CharactersQuery {
    return CharactersQuery(
        page = Input.fromNullable(page),
        filter = Input.fromNullable(
            FilterCharacter(
                name = Input.optional(name),
                status = Input.optional(status),
                species = Input.optional(species),
                type = Input.optional(type),
                gender = Input.optional(gender),
            )
        )
    )
}
