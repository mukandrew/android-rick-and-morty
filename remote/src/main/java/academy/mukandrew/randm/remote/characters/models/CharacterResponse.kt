package academy.mukandrew.randm.remote.characters.models

import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface

internal data class CharacterResponse(
    override val id: Int,
    override val name: String?,
    override val status: String?,
    override val gender: String?,
    override val species: String?,
    override val type: String?,
    override val image: String?
) : CharacterResponseInterface
