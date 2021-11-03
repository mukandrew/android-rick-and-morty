package academy.mukandrew.randm.common.exceptions

class NoContentException(
    override val message: String = "Current requested content is empty"
) : Exception()
