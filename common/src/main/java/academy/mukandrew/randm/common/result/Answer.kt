package academy.mukandrew.randm.common.result

class Answer<out T> internal constructor(
    val value: Any?
) {
    companion object {
        fun <T> success(value: T): Answer<T> = Answer(value)

        fun <T> failure(exception: Exception): Answer<T> = Answer(FailureAnswer(exception))
    }

    val isSuccess: Boolean get() = value !is FailureAnswer

    val isFailure: Boolean get() = value is FailureAnswer

    @Suppress("UNCHECKED_CAST")
    fun getOrNull(): T? =
        when {
            isFailure -> null
            else -> value as T
        }

    fun exceptionOrNull(): Exception? =
        when (value) {
            is FailureAnswer -> value.exception
            else -> null
        }

    override fun toString(): String =
        when (value) {
            is FailureAnswer -> value.toString()
            else -> "Success($value)"
        }

    inline fun onFailure(
        action: (exception: Exception) -> Unit
    ): Answer<T> {
        exceptionOrNull()?.let { action(it) }
        return this
    }

    @Suppress("UNCHECKED_CAST")
    inline fun onSuccess(action: (value: T) -> Unit): Answer<T> {
        if (isSuccess) action(value as T)
        return this
    }
}
