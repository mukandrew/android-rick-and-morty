package academy.mukandrew.randm.data.pagination.mappers

import academy.mukandrew.randm.data.pagination.models.InfoPageResponseInterface
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface
import academy.mukandrew.randm.domain.pagination.models.InfoPage
import academy.mukandrew.randm.domain.pagination.models.PageResult
import kotlin.math.max

fun InfoPageResponseInterface?.toDomainModel(): InfoPage {
    return InfoPage(
        count = max(this?.count ?: 0, 0),
        pages = max(this?.pages ?: 0, 0),
        next = max(this?.next ?: 0, 0),
        prev = max(this?.prev ?: 0, 0)
    )
}

fun <IN, OUT> PageResultResponseInterface<IN>?.toDomainModel(
    mapBlock: (() -> List<OUT>)?
): PageResult<OUT> {
    return PageResult(
        info = this?.info.toDomainModel(),
        results = mapBlock?.invoke().orEmpty()
    )
}
