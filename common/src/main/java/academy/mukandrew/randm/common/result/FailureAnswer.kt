package academy.mukandrew.randm.common.result

internal class FailureAnswer(
    @JvmField
    val exception: Exception
) {
    override fun equals(other: Any?): Boolean =
        other is FailureAnswer && exception == other.exception

    override fun hashCode(): Int = exception.hashCode()
    override fun toString(): String = "FailureResult($exception)"
}
