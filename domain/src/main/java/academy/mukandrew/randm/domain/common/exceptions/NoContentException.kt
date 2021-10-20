package academy.mukandrew.randm.domain.common.exceptions

class NoContentException(
    override val message: String = "Current requested content is empty"
) : Exception()
