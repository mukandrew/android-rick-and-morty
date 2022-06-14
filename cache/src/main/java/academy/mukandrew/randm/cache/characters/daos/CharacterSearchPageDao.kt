package academy.mukandrew.randm.cache.characters.daos

import academy.mukandrew.randm.cache.characters.entities.CharacterSearchPageEntity
import academy.mukandrew.randm.cache.characters.entities.CharacterSearchPageWithPageNumber
import academy.mukandrew.randm.cache.database.BaseDao
import androidx.room.Dao
import androidx.room.Query

@Dao
internal interface CharacterSearchPageDao : BaseDao<CharacterSearchPageEntity> {
    @Query(
        value = """
            SELECT
                CSP.id AS searchPageId,
                CSP.name,
                CSP.status,
                CSP.species,
                CSP.type,
                CSP.gender,
                CSPN.pageNumber,
                CSPN.characterIds,
                CSPN.count,
                CSPN.pages,
                CSPN.next,
                CSPN.prev
            FROM CharacterSearchPageEntity AS CSP
            INNER JOIN CharacterSearchPageNumberEntity AS CSPN ON CSP.id = CSPN.searchPageId
            WHERE
                CSP.name = :name AND
                CSP.status = :status AND 
                CSP.species = :species AND 
                CSP.type = :type AND 
                CSP.gender = :gender AND
                CSPN.pageNumber = :pageNumber
        """
    )
    suspend fun getSearchPage(
        name: String,
        status: String,
        species: String,
        type: String,
        gender: String,
        pageNumber: Int
    ): CharacterSearchPageWithPageNumber?
}
