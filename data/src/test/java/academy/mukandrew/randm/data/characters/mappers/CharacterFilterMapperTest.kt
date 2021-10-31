package academy.mukandrew.randm.data.characters.mappers

import academy.mukandrew.randm.domain.characters.models.CharacterFilter
import academy.mukandrew.randm.domain.characters.models.CharacterGender
import academy.mukandrew.randm.domain.characters.models.CharacterStatus
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CharacterFilterMapperTest {
    @Test
    fun should_ReturnName_WhenIsNotBlankOrEmpty() {
        val characterFilter = CharacterFilter.empty().copy(name = "name")
        val mapped = characterFilter.toMap()
        mapped shouldHaveSize 1
        mapped[CHARACTER_FILTER_NAME] shouldBe "name"
    }

    @Test
    fun should_NotReturnName_WhenIsBlankOrEmpty() {
        var characterFilter = CharacterFilter.empty()
        var mapped = characterFilter.toMap()
        mapped shouldHaveSize 0

        characterFilter = CharacterFilter.empty().copy(name = " ")
        mapped = characterFilter.toMap()
        mapped shouldHaveSize 0
    }

    @Test
    fun should_ReturnStatus_WhenIsNotUnused() {
        val characterFilter = CharacterFilter.empty().copy(
            status = CharacterStatus.ALIVE
        )
        val mapped = characterFilter.toMap()
        mapped shouldHaveSize 1
        mapped[CHARACTER_FILTER_STATUS] shouldBe CharacterStatus.ALIVE.name
    }

    @Test
    fun should_NotReturnStatus_WhenIsUnused() {
        val characterFilter = CharacterFilter.empty()
        val mapped = characterFilter.toMap()
        mapped shouldHaveSize 0
    }

    @Test
    fun should_ReturnSpecies_WhenIsNotBlackOrEmpty() {
        val characterFilter = CharacterFilter.empty().copy(species = "species")
        val mapped = characterFilter.toMap()
        mapped shouldHaveSize 1
        mapped[CHARACTER_FILTER_SPECIES] shouldBe "species"
    }

    @Test
    fun should_NotReturnSpecies_WhenIsBlankOrEmpty() {
        var characterFilter = CharacterFilter.empty()
        var mapped = characterFilter.toMap()
        mapped shouldHaveSize 0

        characterFilter = CharacterFilter.empty().copy(species = " ")
        mapped = characterFilter.toMap()
        mapped shouldHaveSize 0
    }

    @Test
    fun should_ReturnType_WhenIsNotBlankOrEmpty() {
        val characterFilter = CharacterFilter.empty().copy(type = "type")
        val mapped = characterFilter.toMap()
        mapped shouldHaveSize 1
        mapped[CHARACTER_FILTER_TYPE] shouldBe "type"
    }

    @Test
    fun should_NotReturnType_WhenIsBlankOrEmpty() {
        var characterFilter = CharacterFilter.empty()
        var mapped = characterFilter.toMap()
        mapped shouldHaveSize 0

        characterFilter = CharacterFilter.empty().copy(type = " ")
        mapped = characterFilter.toMap()
        mapped shouldHaveSize 0
    }

    @Test
    fun should_ReturnGender_WhenIsNotUnused() {
        val characterFilter = CharacterFilter.empty().copy(
            gender = CharacterGender.FEMALE
        )
        val mapped = characterFilter.toMap()
        mapped shouldHaveSize 1
        mapped[CHARACTER_FILTER_GENDER] shouldBe CharacterGender.FEMALE.name
    }

    @Test
    fun should_NotReturnGender_WhenIsUnused() {
        val characterFilter = CharacterFilter.empty()
        val mapped = characterFilter.toMap()
        mapped shouldHaveSize 0
    }
}
