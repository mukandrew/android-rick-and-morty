package academy.mukandrew.randm.cache.characters.entities

import academy.mukandrew.randm.data.characters.models.CharacterFilterRequestInterface
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class CharacterSearchPageEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    override val name: String,
    override val status: String,
    override val species: String,
    override val type: String,
    override val gender: String
) : CharacterFilterRequestInterface
