package academy.mukandrew.randm.domain.characters.models

data class CharacterFilter(
    val name: String,
    val status: CharacterStatus,
    val species: String,
    val type: String,
    val gender: CharacterGender
) {
    companion object {
        fun empty(): CharacterFilter {
            return CharacterFilter(
                name = String(),
                status = CharacterStatus.UNUSED,
                species = String(),
                type = String(),
                gender = CharacterGender.UNUSED
            )
        }
    }
}
