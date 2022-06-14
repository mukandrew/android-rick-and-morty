package academy.mukandrew.randm.cache.characters.daos

import academy.mukandrew.randm.cache.characters.entities.CharacterEntity
import academy.mukandrew.randm.cache.database.BaseDao
import androidx.room.Dao
import androidx.room.Query

@Dao
internal interface CharacterDao : BaseDao<CharacterEntity> {
    @Query(value = "SELECT * FROM CharacterEntity WHERE id IN (:ids)")
    suspend fun getCharactersById(ids: List<Int>): List<CharacterEntity>

    @Query(value = "SELECT * FROM CharacterEntity WHERE id = :id")
    suspend fun getCharacterById(id: Int): List<CharacterEntity>
}
