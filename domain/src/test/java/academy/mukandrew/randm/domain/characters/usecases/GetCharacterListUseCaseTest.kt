package academy.mukandrew.randm.domain.characters.usecases

import academy.mukandrew.randm.common.exceptions.NoContentException
import academy.mukandrew.randm.common.result.Answer
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.characters.repository.CharacterRepository
import academy.mukandrew.randm.domain.characters.usecases.abstractions.GetCharacterListUseCase
import academy.mukandrew.randm.domain.characters.usecases.implementations.GetCharacterListUseCaseImpl
import academy.mukandrew.randm.domain.pagination.models.PageResult
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.instanceOf
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class GetCharacterListUseCaseTest {
    private val repository: CharacterRepository = mockk()
    private val useCase: GetCharacterListUseCase = GetCharacterListUseCaseImpl(repository)

    @Test
    fun should_ReturnPageResult_WhenSuccess() = runBlocking {
        val pageResult = mockk<PageResult<Character>>()
        every {
            pageResult.results
        } returns listOf(mockk())
        coEvery {
            repository.getCharacterList(any(), any())
        } returns Answer.success(pageResult)

        val response = useCase(pageNumber = 1)

        coVerify(exactly = 1) {
            repository.getCharacterList(page = 1, any())
        }
        response.shouldBeInstanceOf<Answer<PageResult<Character>>>()
        response.isSuccess shouldBe true
        response.getOrNull()?.results shouldBe instanceOf<List<Character>>()
    }

    @Test
    fun should_ReturnNoContent_WhenTheResultListIsEmpty() = runBlocking {
        val pageResult = mockk<PageResult<Character>>()
        every {
            pageResult.results
        } returns emptyList()
        coEvery {
            repository.getCharacterList(any(), any())
        } returns Answer.success(pageResult)

        val response = useCase(pageNumber = 1)

        coVerify(exactly = 1) {
            repository.getCharacterList(page = 1, any())
        }
        response.shouldBeInstanceOf<Answer<NoContentException>>()
        response.isFailure shouldBe true
    }

    @Test
    fun should_ReturnError_WhenReceiveError() = runBlocking {
        coEvery {
            repository.getCharacterList(any(), any())
        } returns Answer.failure(Exception())

        val response = useCase(pageNumber = 1)
        coVerify(exactly = 1) {
            repository.getCharacterList(page = 1, any())
        }
        response.shouldBeInstanceOf<Answer<Exception>>()
        response.isFailure shouldBe true
    }
}
