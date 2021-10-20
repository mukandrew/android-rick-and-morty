package academy.mukandrew.randm.domain.characters.models

/**
 * @param id [Int] The id of the character
 * @param name [String] The name of the character
 * @param status [CharacterStatus] The status of the character
 * @param gender [CharacterGender] The gender of the character
 * @param species [String] The species of the character
 * @param type [String] The type of subspecies of the character
 * @param imageUrl [String] Link to the character's image. All images are 300x300px and most
 * are medium shots or portraits since they are intended to be used as avatars.
 */
data class Character(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val gender: CharacterGender,
    val species: String,
    val type: String,
    val imageUrl: String
)
