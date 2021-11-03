package academy.mukandrew.randm.remote.characters.mappers.queries

import academy.mukandrew.randm.data.characters.mappers.CHARACTER_FILTER_GENDER
import academy.mukandrew.randm.data.characters.mappers.CHARACTER_FILTER_NAME
import academy.mukandrew.randm.data.characters.mappers.CHARACTER_FILTER_SPECIES
import academy.mukandrew.randm.data.characters.mappers.CHARACTER_FILTER_STATUS
import academy.mukandrew.randm.data.characters.mappers.CHARACTER_FILTER_TYPE
import academy.mukandrew.randm.remote.CharactersQuery
import academy.mukandrew.randm.remote.type.FilterCharacter
import com.apollographql.apollo.api.Input

internal fun getCharactersQuery(
    page: Int,
    filters: Map<String, String>
): CharactersQuery {
    return CharactersQuery(
        page = Input.fromNullable(page),
        filter = Input.fromNullable(
            FilterCharacter(
                name = Input.optional(
                    filters.getOrDefault(
                        CHARACTER_FILTER_NAME,
                        defaultValue = null
                    )
                ),
                status = Input.optional(
                    filters.getOrDefault(
                        CHARACTER_FILTER_STATUS,
                        defaultValue = null
                    )
                ),
                species = Input.optional(
                    filters.getOrDefault(
                        CHARACTER_FILTER_SPECIES,
                        defaultValue = null
                    )
                ),
                type = Input.optional(
                    filters.getOrDefault(
                        CHARACTER_FILTER_TYPE,
                        defaultValue = null
                    )
                ),
                gender = Input.optional(
                    filters.getOrDefault(
                        CHARACTER_FILTER_GENDER,
                        defaultValue = null
                    )
                ),
            )
        )
    )
}
