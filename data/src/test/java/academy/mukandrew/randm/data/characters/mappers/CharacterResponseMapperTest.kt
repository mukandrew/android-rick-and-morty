package academy.mukandrew.randm.data.characters.mappers

import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import academy.mukandrew.randm.domain.characters.models.CharacterGender
import academy.mukandrew.randm.domain.characters.models.CharacterStatus
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CharacterResponseMapperTest {
    private val characterResponse = mockk<CharacterResponseInterface>()

    @Before
    fun setup() {
        every { characterResponse.id } returns 10
        every { characterResponse.name } returns "name"
        every { characterResponse.gender } returns "Male"
        every { characterResponse.image } returns "image"
        every { characterResponse.species } returns "Human"
        every { characterResponse.status } returns "Alive"
        every { characterResponse.type } returns "type"
    }

    @Test
    fun should_MapResponse_Success() {
        val character = characterResponse.toDomainModel()
        character.id shouldBe 10
        character.name shouldBe "name"
        character.gender shouldBe CharacterGender.MALE
        character.imageUrl shouldBe "image"
        character.species shouldBe "Human"
        character.status shouldBe CharacterStatus.ALIVE
        character.type shouldBe "type"
    }

    @Test
    fun should_MapGenders_Success() {
        var character = characterResponse.toDomainModel()
        character.gender shouldBe CharacterGender.MALE

        every { characterResponse.gender } returns "Female"
        character = characterResponse.toDomainModel()
        character.gender shouldBe CharacterGender.FEMALE

        every { characterResponse.gender } returns "Genderless"
        character = characterResponse.toDomainModel()
        character.gender shouldBe CharacterGender.GENDERLESS

        every { characterResponse.gender } returns "Unknown"
        character = characterResponse.toDomainModel()
        character.gender shouldBe CharacterGender.UNKNOWN

        every { characterResponse.gender } returns "potato"
        character = characterResponse.toDomainModel()
        character.gender shouldBe CharacterGender.UNKNOWN
    }

    @Test
    fun should_MapStatus_Success() {
        var character = characterResponse.toDomainModel()
        character.status shouldBe CharacterStatus.ALIVE

        every { characterResponse.status } returns "Dead"
        character = characterResponse.toDomainModel()
        character.status shouldBe CharacterStatus.DEAD

        every { characterResponse.status } returns "Unknown"
        character = characterResponse.toDomainModel()
        character.status shouldBe CharacterStatus.UNKNOWN

        every { characterResponse.status } returns "undead"
        character = characterResponse.toDomainModel()
        character.status shouldBe CharacterStatus.UNKNOWN
    }
}
