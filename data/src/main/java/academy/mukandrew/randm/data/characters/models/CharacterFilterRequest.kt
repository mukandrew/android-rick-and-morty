package academy.mukandrew.randm.data.characters.models

internal data class CharacterFilterRequest(
    override val name: String,
    override val status: String,
    override val species: String,
    override val type: String,
    override val gender: String
) : CharacterFilterRequestInterface
