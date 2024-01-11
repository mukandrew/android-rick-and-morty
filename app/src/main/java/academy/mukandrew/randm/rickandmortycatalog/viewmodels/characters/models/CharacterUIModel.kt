package academy.mukandrew.randm.rickandmortycatalog.viewmodels.characters.models

import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.models.CharacterGender
import academy.mukandrew.randm.domain.characters.models.CharacterStatus

data class CharacterUIModel(
    override val id: Int = 0,
    override val name: String = String(),
    override val status: CharacterStatus = CharacterStatus.UNKNOWN,
    override val gender: CharacterGender = CharacterGender.UNKNOWN,
    override val species: String = String(),
    override val type: String = String(),
    override val imageUrl: String = String()
) : Character {
    fun getTitle(): String {
        return "$id. $name"
    }

    fun getSubtitle(): String {
        return buildString {
            append(species)
            if (type.isNotBlank()) {
                append(" - ")
                append(type)
            }
        }
    }

    fun getNamedStatus(): String {
        return status.toString().lowercase()
    }

    fun getNamedGender(): String {
        return gender.toString().lowercase().replaceFirstChar { it.uppercase() }
    }
}
