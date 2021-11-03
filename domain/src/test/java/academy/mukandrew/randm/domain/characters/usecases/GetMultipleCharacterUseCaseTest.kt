package academy.mukandrew.randm.domain.characters.usecases

import academy.mukandrew.randm.common.exceptions.NoContentException
import academy.mukandrew.randm.common.result.Answer
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.repository.CharacterRepository
import academy.mukandrew.randm.domain.characters.usecases.abstractions.GetMultipleCharacterUseCase
import academy.mukandrew.randm.domain.characters.usecases.implementations.GetMultipleCharacterUseCaseImpl
import io.kotest.matchers.collections.haveSize
import io.kotest.matchers.should
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
internal class GetMultipleCharacterUseCaseTest {
    private val repository: CharacterRepository = mockk()
    private val useCase: GetMultipleCharacterUseCase = GetMultipleCharacterUseCaseImpl(repository)

    @Test
    fun should_ReturnListCharacter_WhenSuccess() = runBlocking {
        val ids = listOf(10, 20)
        val list = listOf<Character>(mockk())
        coEvery {
            repository.getMultipleCharactersById(ids)
        } returns Answer.success(list)

        val answer = useCase(ids)

        coVerify(exactly = 1) {
            repository.getMultipleCharactersById(ids)
        }
        answer.shouldBeInstanceOf<Answer<List<Character>>>()
        answer.isSuccess shouldBe true
        answer.getOrNull().orEmpty() should haveSize(list.size)
    }

    @Test
    fun should_ReturnNoContent_WhenReceiveEmptyList() = runBlocking {
        val ids = listOf(10, 20)
        coEvery {
            repository.getMultipleCharactersById(ids)
        } returns Answer.success(emptyList())

        val answer = useCase(ids)

        coVerify(exactly = 1) {
            repository.getMultipleCharactersById(ids)
        }
        answer.shouldBeInstanceOf<Answer<NoContentException>>()
        answer.isFailure shouldBe true
    }

    @Test
    fun should_ReturnException_WhenReceiveError() = runBlocking {
        val ids = listOf(10, 20)
        coEvery {
            repository.getMultipleCharactersById(ids)
        } returns Answer.failure(Exception())

        val answer = useCase(ids)

        coVerify(exactly = 1) {
            repository.getMultipleCharactersById(ids)
        }
        answer.shouldBeInstanceOf<Answer<Exception>>()
        answer.isFailure shouldBe true
    }
}
