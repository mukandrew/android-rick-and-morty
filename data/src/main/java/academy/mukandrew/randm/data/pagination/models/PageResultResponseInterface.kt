package academy.mukandrew.randm.data.pagination.models

interface PageResultResponseInterface<T> {
    val info: InfoPageResponseInterface
    val results: List<T>
}
