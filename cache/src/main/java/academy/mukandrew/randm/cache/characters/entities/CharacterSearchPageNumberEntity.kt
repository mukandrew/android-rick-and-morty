package academy.mukandrew.randm.cache.characters.entities

import academy.mukandrew.randm.data.pagination.models.InfoPageResponseInterface
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class CharacterSearchPageNumberEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val searchPageId: Long,
    val pageNumber: Int,
    override val count: Int,
    override val pages: Int,
    override val next: Int,
    override val prev: Int,
    val characterIds: List<Long>
) : InfoPageResponseInterface
