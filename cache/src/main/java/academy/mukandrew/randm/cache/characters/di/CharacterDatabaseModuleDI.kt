package academy.mukandrew.randm.cache.characters.di

import academy.mukandrew.randm.cache.characters.daos.CharacterDao
import academy.mukandrew.randm.cache.characters.daos.CharacterSearchPageDao
import academy.mukandrew.randm.cache.database.ApplicationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object CharacterDatabaseModuleDI {

    @Provides
    fun provideCharacterDao(database: ApplicationDatabase): CharacterDao {
        return database.characterDao()
    }

    @Provides
    fun provideCharacterSearchPageDao(database: ApplicationDatabase): CharacterSearchPageDao {
        return database.characterSearchPageDao()
    }
}
