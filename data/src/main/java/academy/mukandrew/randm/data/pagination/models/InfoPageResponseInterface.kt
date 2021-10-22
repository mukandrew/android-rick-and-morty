package academy.mukandrew.randm.data.pagination.models

interface InfoPageResponseInterface {
    val count: Int?
    val pages: Int?
    val next: Int?
    val prev: Int?
}
