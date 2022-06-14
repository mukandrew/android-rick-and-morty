package academy.mukandrew.randm.cache.characters.mappers

import academy.mukandrew.randm.cache.characters.entities.CharacterEntity
import academy.mukandrew.randm.cache.characters.entities.CharacterSearchPageWithPageNumber
import academy.mukandrew.randm.cache.pagination.models.LocalInfoPage
import academy.mukandrew.randm.cache.pagination.models.LocalPageResult
import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
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
