package academy.mukandrew.randm.cache.characters.mappers

import academy.mukandrew.randm.cache.characters.entities.CharacterEntity
import academy.mukandrew.randm.cache.characters.entities.CharacterSearchPageEntity
import academy.mukandrew.randm.cache.characters.entities.CharacterSearchPageNumberEntity
import academy.mukandrew.randm.cache.characters.entities.CharacterSearchPageWithPageNumber
import academy.mukandrew.randm.cache.pagination.models.LocalInfoPage
import academy.mukandrew.randm.cache.pagination.models.LocalPageResult
import academy.mukandrew.randm.data.characters.models.CharacterFilterRequestInterface
import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.data.pagination.models.InfoPageResponseInterface
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface

internal fun CharacterSearchPageWithPageNumber.toResponse(
    results: List<CharacterEntity>
): PageResultResponseInterface<CharacterResponseInterface> {
    return LocalPageResult(
        info = LocalInfoPage(
            count = count,
            pages = pages,
            next = next,
            prev = prev,
        ),
        results = results
    )
}

internal fun CharacterResponseInterface.toEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        status = status,
        gender = gender,
        species = species,
        type = type,
        image = image
    )
}

internal fun CharacterFilterRequestInterface.toEntity(): CharacterSearchPageEntity {
    return CharacterSearchPageEntity(
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
    )
}

internal fun InfoPageResponseInterface.toCharacterEntity(
    searchPageId: Long,
    pageNumber: Int,
    charactersId: List<Long>
): CharacterSearchPageNumberEntity {
    return CharacterSearchPageNumberEntity(
        searchPageId = searchPageId,
        pageNumber = pageNumber,
        count = count ?: 0,
        pages = pages ?: 0,
        next = next ?: (pageNumber + 1),
        prev = prev ?: (pageNumber - 1),
        characterIds = charactersId
    )
}
