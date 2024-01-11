package academy.mukandrew.randm.domain.characters.models

data class CharacterDomainModel(
    override val id: Int,
    override val name: String,
    override val status: CharacterStatus,
    override val gender: CharacterGender,
    override val species: String,
    override val type: String,
    override val imageUrl: String
) : Character
