package academy.mukandrew.randm.rickandmortycatalog.viewmodels.models

sealed interface BaseViewState<out T : Any> {
    data object LoadingViewState : BaseViewState<Nothing>
    data class SuccessViewState<T : Any>(val data: T) : BaseViewState<T>
    data class ErrorViewState(val throwable: Throwable) : BaseViewState<Nothing>
}
