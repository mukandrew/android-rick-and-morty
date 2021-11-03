package academy.mukandrew.randm.remote.pagination.models

import academy.mukandrew.randm.data.pagination.models.InfoPageResponseInterface
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface

internal data class PageResultResponse<T>(
    override val info: InfoPageResponseInterface?,
    override val results: List<T>
) : PageResultResponseInterface<T>
