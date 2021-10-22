package academy.mukandrew.randm.domain.characters.usecases

import academy.mukandrew.randm.common.result.Answer
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.repository.CharacterRepository
import academy.mukandrew.randm.domain.characters.usecases.abstractions.GetCharacterUseCase
import academy.mukandrew.randm.domain.characters.usecases.implementations.GetCharacterUseCaseImpl
import academy.mukandrew.randm.domain.common.exceptions.NoContentException
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class GetCharacterUseCaseTest {
    private val repository: CharacterRepository = mockk()
    private val useCase: GetCharacterUseCase = GetCharacterUseCaseImpl(repository)

    @Test
    fun should_ReturnCharacter_WhenSuccess() = runBlocking {
        val id = 10
        val character: Character = mockk()
        coEvery {
            repository.getCharacterById(id)
        } returns Answer.success(character)

        val answer = useCase(id)
        coVerify(exactly = 1) {
            repository.getCharacterById(id)
        }
        answer.shouldBeInstanceOf<Answer<Character>>()
        answer.isSuccess shouldBe true
    }

    @Test
    fun should_ReturnException_WhenError() = runBlocking {
        val id = 10
        coEvery {
            repository.getCharacterById(id)
        } returns Answer.failure(NoContentException())

        val answer = useCase(id)
        coVerify(exactly = 1) {
            repository.getCharacterById(id)
        }
        answer.shouldBeInstanceOf<Answer<NoContentException>>()
        answer.isFailure shouldBe true
    }
}
