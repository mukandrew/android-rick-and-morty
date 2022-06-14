package academy.mukandrew.randm.cache.database

import academy.mukandrew.randm.cache.characters.daos.CharacterDao
import academy.mukandrew.randm.cache.characters.entities.CharacterEntity
import academy.mukandrew.randm.cache.converters.IdTypeConverter
import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [CharacterEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    value = [IdTypeConverter::class]
)
abstract class ApplicationDatabase : RoomDatabase() {
    internal abstract fun characterDao(): CharacterDao

    companion object {
        private const val SQLITE_DB_NAME = "RickAndMortyLocalDatabase"

        fun getDatabaseInstance(context: Application): ApplicationDatabase {
            return Room.databaseBuilder(
                context,
                ApplicationDatabase::class.java,
                SQLITE_DB_NAME
            ).build()
        }
    }
}
