package academy.mukandrew.randm.remote.characters.mappers.queries

import academy.mukandrew.randm.data.characters.models.CharacterFilterRequestInterface
import academy.mukandrew.randm.remote.CharactersQuery
import academy.mukandrew.randm.remote.type.FilterCharacter
import com.apollographql.apollo3.api.Optional

internal fun CharacterFilterRequestInterface.getCharactersQuery(
    page: Int
): CharactersQuery {
    return CharactersQuery(
        page = Optional.Present(page),
        filter = Optional.Present(
            FilterCharacter(
                name = Optional.presentIfNotNull(name),
                status = Optional.presentIfNotNull(status),
                species = Optional.presentIfNotNull(species),
                type = Optional.presentIfNotNull(type),
                gender = Optional.presentIfNotNull(gender),
            )
        )
    )
}
