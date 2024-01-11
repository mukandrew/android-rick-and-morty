package academy.mukandrew.randm.domain.characters.models

/**
 * @property id [Int] The id of the character
 * @property name [String] The name of the character
 * @property status [CharacterStatus] The status of the character
 * @property gender [CharacterGender] The gender of the character
 * @property species [String] The species of the character
 * @property type [String] The type of subspecies of the character
 * @property imageUrl [String] Link to the character's image. All images are 300x300px and most
 * are medium shots or portraits since they are intended to be used as avatars.
 */
interface Character {
    val id: Int
    val name: String
    val status: CharacterStatus
    val gender: CharacterGender
    val species: String
    val type: String
    val imageUrl: String
}
