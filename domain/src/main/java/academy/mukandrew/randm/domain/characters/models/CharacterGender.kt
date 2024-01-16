package academy.mukandrew.randm.domain.characters.models

enum class CharacterGender {
    FEMALE, MALE, GENDERLESS, UNKNOWN, UNUSED;

    override fun toString(): String {
        return when (this) {
            UNUSED -> String()
            else -> this.name
        }
    }

    companion object {
        fun asList() = CharacterStatus.entries.filter { it != CharacterStatus.UNUSED }
    }
}
