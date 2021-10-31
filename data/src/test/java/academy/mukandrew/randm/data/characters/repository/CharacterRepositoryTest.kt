package academy.mukandrew.randm.data.characters.repository

import academy.mukandrew.randm.data.characters.datasource.CharacterDataSource
import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.data.pagination.models.InfoPageResponseInterface
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface
import academy.mukandrew.randm.domain.characters.models.CharacterFilter
import academy.mukandrew.randm.domain.characters.repository.CharacterRepository
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CharacterRepositoryTest {
    private val localDataSource: CharacterDataSource =
        mockk(name = "Local")
    private val remoteDataSource: CharacterDataSource = mockk(name = "remote")
    private val repository: CharacterRepository =
        CharacterRepositoryImpl(localDataSource, remoteDataSource)

    private val infoPageResponse = mockk<InfoPageResponseInterface>()
    private val pageResponse = mockk<PageResultResponseInterface<CharacterResponseInterface>>()
    private val characterResponse = mockk<CharacterResponseInterface>()

    @Before
    fun setup() {
        every { infoPageResponse.count } returns 0
        every { infoPageResponse.next } returns 1
        every { infoPageResponse.prev } returns 0
        every { infoPageResponse.pages } returns 10
        every { pageResponse.info } returns infoPageResponse
        every { pageResponse.results } returns listOf(characterResponse)
        every { characterResponse.id } returns 10
        every { characterResponse.name } returns "name"
        every { characterResponse.gender } returns "Male"
        every { characterResponse.image } returns "image"
        every { characterResponse.species } returns "Human"
        every { characterResponse.status } returns "Alive"
        every { characterResponse.type } returns ""
    }

    @Test
    fun getCharacterList_Should_ReturnLocalList_WhenLocalReturnSuccess() = runBlocking {
        val page = 1
        val filter = CharacterFilter.empty()
        coEvery {
            localDataSource.getCharacterList(any(), any())
        } returns pageResponse

        val answer = repository.getCharacterList(page, filter)

        answer.isSuccess shouldBe true
    }

    @Test
    fun getCharacterList_Should_ReturnFromRemote_WhenLocalThrowsException() = runBlocking {
        val page = 1
        val filter = CharacterFilter.empty()
        coEvery {
            localDataSource.getCharacterList(any(), any())
        } throws Exception()
        coEvery {
            remoteDataSource.getCharacterList(any(), any())
        } returns pageResponse

        val answer = repository.getCharacterList(page, filter)

        answer.isSuccess shouldBe true
    }

    @Test
    fun getCharacterList_Should_ReturnFailure_WhenRemoteThrowsException() = runBlocking {
        val page = 1
        val filter = CharacterFilter.empty()
        coEvery {
            localDataSource.getCharacterList(any(), any())
        } throws Exception("error from local")
        coEvery {
            remoteDataSource.getCharacterList(any(), any())
        } throws Exception("error from remote")

        val answer = repository.getCharacterList(page, filter)

        answer.isFailure shouldBe true
        answer.exceptionOrNull()?.message shouldBe "error from remote"
    }

    @Test
    fun getCharacterById_Should_ReturnCharacter_WhenLocalSuccess() = runBlocking {
        val id = 1
        coEvery {
            localDataSource.getCharacterById(id)
        } returns characterResponse

        val answer = repository.getCharacterById(id)

        answer.isSuccess shouldBe true
    }

    @Test
    fun getCharacterById_Should_ReturnCharacterFromRemote_WhenLocalThrowsException() = runBlocking {
        val id = 1
        coEvery {
            localDataSource.getCharacterById(id)
        } throws Exception()
        coEvery {
            remoteDataSource.getCharacterById(id)
        } returns characterResponse

        val answer = repository.getCharacterById(id)

        answer.isSuccess shouldBe true
    }

    @Test
    fun getCharacterById_Should_ReturnFailure_WhenRemoteThrowsException() = runBlocking {
        val id = 1
        coEvery {
            localDataSource.getCharacterById(id)
        } throws Exception("error from local")
        coEvery {
            remoteDataSource.getCharacterById(id)
        } throws Exception("error from remote")

        val answer = repository.getCharacterById(id)

        answer.isFailure shouldBe true
        answer.exceptionOrNull()?.message shouldBe "error from remote"
    }

    @Test
    fun getMultipleCharactersById_Should_ReturnList_WhenLocalSuccess() = runBlocking {
        val ids = listOf(1, 2)
        coEvery {
            localDataSource.getMultipleCharactersById(ids)
        } returns listOf(characterResponse)

        val answer = repository.getMultipleCharactersById(ids)

        answer.isSuccess shouldBe true
    }

    @Test
    fun getMultipleCharactersById_Should_ReturnRemote_WhenLocalThrowsException() = runBlocking {
        val ids = listOf(1, 2)
        coEvery {
            localDataSource.getMultipleCharactersById(ids)
        } throws Exception()
        coEvery {
            remoteDataSource.getMultipleCharactersById(ids)
        } returns listOf(characterResponse)

        val answer = repository.getMultipleCharactersById(ids)

        answer.isSuccess shouldBe true
    }

    @Test
    fun getMultipleCharactersById_Should_ReturnFailure_WhenRemoteThrowsException() = runBlocking {
        val ids = listOf(1, 2)
        coEvery {
            localDataSource.getMultipleCharactersById(ids)
        } throws Exception("error from local")
        coEvery {
            remoteDataSource.getMultipleCharactersById(ids)
        } throws Exception("error from remote")

        val answer = repository.getMultipleCharactersById(ids)

        answer.isFailure shouldBe true
        answer.exceptionOrNull()?.message shouldBe "error from remote"
    }
}
