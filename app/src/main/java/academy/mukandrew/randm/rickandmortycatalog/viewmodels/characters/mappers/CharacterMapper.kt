package academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.mappers

import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.models.CharacterUIModel

internal fun List<Character>?.toListUIModel() = this?.map { it.toUIModel() }.orEmpty()

internal fun Character.toUIModel(): CharacterUIModel {
    return CharacterUIModel(
        id = id,
        name = name,
        status = status,
        gender = gender,
        species = species,
        type = type,
        imageUrl = imageUrl
    )
}
