package academy.mukandrew.randm.data.characters.mappers

import academy.mukandrew.randm.common.exceptions.NoContentException
import academy.mukandrew.randm.common.utils.safeValueOf
import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.models.CharacterDomainModel
import academy.mukandrew.randm.domain.characters.models.CharacterGender
import academy.mukandrew.randm.domain.characters.models.CharacterStatus

fun CharacterResponseInterface?.toDomainModel(): Character {
    if (this == null) throw NoContentException()

    return CharacterDomainModel(
        id = id,
        name = name.orEmpty(),
        status = safeValueOf(status, CharacterStatus.UNKNOWN),
        gender = safeValueOf(gender, CharacterGender.UNKNOWN),
        species = species.orEmpty(),
        type = type.orEmpty(),
        imageUrl = image.orEmpty(),
    )
}

fun List<CharacterResponseInterface>?.toDomainModel(): List<Character> {
    return this?.map { it.toDomainModel() }.orEmpty()
}
