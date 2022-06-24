package academy.mukandrew.randm.cache.characters.entities

internal data class CharacterSearchPageWithPageNumber(
    val searchPageId: Long,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val pageNumber: Int,
    val count: Int,
    val pages: Int,
    val next: Int,
    val prev: Int,
    val characterIds: List<Long>
)
