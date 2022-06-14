package academy.mukandrew.randm.data.characters.mappers

import academy.mukandrew.randm.data.characters.models.CharacterFilterRequest
import academy.mukandrew.randm.data.characters.models.CharacterFilterRequestInterface
import academy.mukandrew.randm.domain.characters.models.CharacterFilter
import academy.mukandrew.randm.domain.characters.models.CharacterGender
import academy.mukandrew.randm.domain.characters.models.CharacterStatus

const val CHARACTER_FILTER_NAME = "name"
const val CHARACTER_FILTER_STATUS = "status"
const val CHARACTER_FILTER_SPECIES = "species"
const val CHARACTER_FILTER_TYPE = "type"
const val CHARACTER_FILTER_GENDER = "gender"

fun CharacterFilter.toMap(): Map<String, String> {
    return mutableMapOf<String, String>().apply {
        if (name.isNotBlank()) set(CHARACTER_FILTER_NAME, name)
        if (status != CharacterStatus.UNUSED) set(CHARACTER_FILTER_STATUS, status.name)
        if (species.isNotBlank()) set(CHARACTER_FILTER_SPECIES, species)
        if (type.isNotBlank()) set(CHARACTER_FILTER_TYPE, type)
        if (gender != CharacterGender.UNUSED) set(CHARACTER_FILTER_GENDER, gender.name)
    }
}

fun CharacterFilter.toRequest(): CharacterFilterRequestInterface {
    return CharacterFilterRequest(
        name = name,
        status = status.toString(),
        species = species,
        type = type,
        gender = gender.toString(),
    )
}
