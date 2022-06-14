package academy.mukandrew.randm.cache.pagination.models

import academy.mukandrew.randm.data.pagination.models.InfoPageResponseInterface

internal data class LocalInfoPage(
    override val count: Int?,
    override val pages: Int?,
    override val next: Int?,
    override val prev: Int?
) : InfoPageResponseInterface
