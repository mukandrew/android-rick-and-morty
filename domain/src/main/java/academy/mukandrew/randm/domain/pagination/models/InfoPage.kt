package academy.mukandrew.randm.domain.pagination.models

data class InfoPage(
    val count: Int,
    val pages: Int,
    val next: Int,
    val prev: Int
) {
    val currentPage: Int
        get() {
            return when {
                prev == 0 -> 1
                next == 0 -> prev + 1
                else -> prev - next
            }
        }
}
