package academy.mukandrew.randm.data.characters.models

interface CharacterResponseInterface {
    val id: Int
    val name: String?
    val status: String?
    val gender: String?
    val species: String?
    val type: String?
    val image: String?
}
