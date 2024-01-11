package academy.mukandrew.randm.domain.characters.models

enum class CharacterGender {
    FEMALE, MALE, GENDERLESS, UNKNOWN, UNUSED;

    override fun toString(): String {
        return when (this) {
            UNUSED -> String()
            else -> this.name
        }
    }

    fun firstCaseName() = toString().lowercase().replaceFirstChar { it.uppercase() }

    companion object {
        fun asList() = CharacterStatus.values().filter { it != CharacterStatus.UNUSED }
    }
}
