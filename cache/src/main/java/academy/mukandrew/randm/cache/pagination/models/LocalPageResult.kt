package academy.mukandrew.randm.cache.pagination.models

import academy.mukandrew.randm.data.pagination.models.InfoPageResponseInterface
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface

internal data class LocalPageResult<T>(
    override val info: InfoPageResponseInterface,
    override val results: List<T>
) : PageResultResponseInterface<T>
