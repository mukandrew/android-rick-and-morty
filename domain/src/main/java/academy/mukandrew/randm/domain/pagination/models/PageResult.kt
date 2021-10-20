package academy.mukandrew.randm.domain.pagination.models

data class PageResult<T>(
    val info: InfoPage,
    val results: List<T>
)
