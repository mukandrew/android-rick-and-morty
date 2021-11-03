package academy.mukandrew.randm.remote.characters.mappers.responses

import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.remote.CharacterQuery
import academy.mukandrew.randm.remote.CharactersByIdsQuery
import academy.mukandrew.randm.remote.characters.models.CharacterResponse

internal fun CharacterQuery.Data.toResponseModel(): CharacterResponseInterface {
    return CharacterResponse(
        id = character?.id?.toInt() ?: throw NullPointerException("Character ID NotFound"),
        name = character.name,
        status = character.status,
        gender = character.gender,
        species = character.species,
        type = character.type,
        image = character.image,
    )
}

internal fun CharactersByIdsQuery.Data.toResponseModel(): List<CharacterResponseInterface> {
    return charactersByIds?.mapNotNull { it?.toResponseModel() }.orEmpty()
}

internal fun CharactersByIdsQuery.CharactersById.toResponseModel(): CharacterResponseInterface {
    return CharacterResponse(
        id = id?.toInt() ?: throw NullPointerException("Character ID NotFound"),
        name = name,
        status = status,
        gender = gender,
        species = species,
        type = type,
        image = image,
    )
}
