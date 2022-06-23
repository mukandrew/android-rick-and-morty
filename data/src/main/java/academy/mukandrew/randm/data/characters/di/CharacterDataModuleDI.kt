package academy.mukandrew.randm.data.characters.di

import academy.mukandrew.randm.data.characters.repository.CharacterRepositoryImpl
import academy.mukandrew.randm.domain.characters.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface CharacterDataModuleDI {
    @Binds
    fun bindCharacterRepository(
        characterRepositoryImpl: CharacterRepositoryImpl
    ): CharacterRepository
}
