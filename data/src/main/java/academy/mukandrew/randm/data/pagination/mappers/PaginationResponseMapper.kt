package academy.mukandrew.randm.data.pagination.mappers

import academy.mukandrew.randm.data.pagination.models.InfoPageResponseInterface
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface
import academy.mukandrew.randm.domain.pagination.models.InfoPage
import academy.mukandrew.randm.domain.pagination.models.PageResult

fun InfoPageResponseInterface.toDomainModel(): InfoPage {
    return InfoPage(
        count = count ?: 0,
        pages = pages ?: 0,
        next = next ?: 0,
        prev = prev ?: 0,
    )
}

fun <IN, OUT> PageResultResponseInterface<IN>.toDomainModel(
    mapBlock: () -> List<OUT>
): PageResult<OUT> {
    return PageResult(
        info = info.toDomainModel(),
        results = mapBlock.invoke()
    )
}
