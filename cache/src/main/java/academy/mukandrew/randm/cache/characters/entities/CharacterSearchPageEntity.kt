package academy.mukandrew.randm.cache.characters.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class CharacterSearchPageEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String
)
