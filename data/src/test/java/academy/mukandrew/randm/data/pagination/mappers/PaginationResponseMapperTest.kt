package academy.mukandrew.randm.data.pagination.mappers

import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.data.pagination.models.InfoPageResponseInterface
import academy.mukandrew.randm.data.pagination.models.PageResultResponseInterface
import academy.mukandrew.randm.domain.characters.models.Character
import academy.mukandrew.randm.domain.pagination.models.InfoPage
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class PaginationResponseMapperTest {
    private val infoPage: InfoPageResponseInterface = mockk()
    private val pageResult: PageResultResponseInterface<CharacterResponseInterface> = mockk()

    @Before
    fun setup() {
        every { infoPage.count } returns 1
        every { infoPage.pages } returns 2
        every { infoPage.next } returns 3
        every { infoPage.prev } returns 4
        every { pageResult.info } returns infoPage
    }

    @Test
    fun should_MapInfoPage_successfully() {
        val mapped = infoPage.toDomainModel()
        mapped.count shouldBe 1
        mapped.pages shouldBe 2
        mapped.next shouldBe 3
        mapped.prev shouldBe 4
    }

    @Test
    fun should_MapCountAsZero_WhenReceiveNull() {
        every { infoPage.count } returns null
        val mapped = infoPage.toDomainModel()
        mapped.count shouldBe 0
    }

    @Test
    fun should_MapPagesAsZero_WhenReceiveNull() {
        every { infoPage.pages } returns null
        val mapped = infoPage.toDomainModel()
        mapped.pages shouldBe 0
    }

    @Test
    fun should_MapNextAsZero_WhenReceiveNull() {
        every { infoPage.next } returns null
        val mapped = infoPage.toDomainModel()
        mapped.next shouldBe 0
    }

    @Test
    fun should_MapPrevAsZero_WhenReceiveNull() {
        every { infoPage.prev } returns null
        val mapped = infoPage.toDomainModel()
        mapped.prev shouldBe 0
    }

    @Test
    fun should_MapPageResult_successfully() {
        val mapped = pageResult.toDomainModel { emptyList<Character>() }
        mapped.info shouldBe InfoPage(count = 1, pages = 2, next = 3, prev = 4)
        mapped.results shouldBe emptyList()
    }
}
