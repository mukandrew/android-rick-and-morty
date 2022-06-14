package academy.mukandrew.randm.cache.characters.entities

import academy.mukandrew.randm.data.characters.models.CharacterResponseInterface
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class CharacterEntity(
    @PrimaryKey override val id: Int,
    override val name: String?,
    override val status: String?,
    override val gender: String?,
    override val species: String?,
    override val type: String?,
    override val image: String?
) : CharacterResponseInterface
