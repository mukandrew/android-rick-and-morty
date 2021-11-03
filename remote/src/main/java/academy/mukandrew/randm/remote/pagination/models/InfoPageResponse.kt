package academy.mukandrew.randm.remote.pagination.models

import academy.mukandrew.randm.data.pagination.models.InfoPageResponseInterface

internal data class InfoPageResponse(
    override val count: Int?,
    override val pages: Int?,
    override val next: Int?,
    override val prev: Int?
) : InfoPageResponseInterface
