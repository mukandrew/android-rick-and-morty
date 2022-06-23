package academy.mukandrew.randm.cache.characters.di

import academy.mukandrew.randm.cache.characters.datasource.CharacterLocalDataSource
import academy.mukandrew.randm.data.characters.datasource.CharacterDataSource
import academy.mukandrew.randm.data.characters.di.CharacterLocalDataSourceQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal interface CharacterLocalModuleDI {
    @CharacterLocalDataSourceQualifier
    @Binds
    fun bindCharacterLocalDataSource(
        characterLocalDataSource: CharacterLocalDataSource
    ): CharacterDataSource
}
