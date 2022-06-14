package academy.mukandrew.randm.remote.characters.mappers.responses

import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface
import academy.mukandrew.randm.remote.CharactersQuery
import academy.mukandrew.randm.remote.characters.models.CharacterResponse
import academy.mukandrew.randm.remote.pagination.models.InfoPageResponse
import academy.mukandrew.randm.remote.pagination.models.PageResultResponse

internal fun CharactersQuery.Data.toResponseModel():
    PageResultResponseInterface<CharacterResponseInterface> {
    return PageResultResponse(
        info = this.characters?.info.toResponseModel(),
        results = this.characters?.results?.toResponseModel().orEmpty()
    )
}

internal fun CharactersQuery.Info?.toResponseModel(): InfoPageResponse {
    return InfoPageResponse(
        count = this?.count ?: 0,
        pages = this?.pages ?: 0,
        next = this?.next ?: 0,
        prev = this?.prev ?: 0
    )
}

internal fun List<CharactersQuery.Result?>.toResponseModel(): List<CharacterResponse> {
    return mapNotNull { it?.toResponseModel() }
}

internal fun CharactersQuery.Result.toResponseModel(): CharacterResponse {
    return CharacterResponse(
        id = id?.toInt() ?: throw NullPointerException("Character ID NotFound"),
        name = name,
        status = status,
        gender = gender,
        species = species,
        type = type,
        image = image,
    )
}
