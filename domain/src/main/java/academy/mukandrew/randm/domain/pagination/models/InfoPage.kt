package academy.mukandrew.randm.domain.pagination.models

data class InfoPage(
    val count: Int,
    val pages: Int,
    val next: Int,
    val prev: Int
)
