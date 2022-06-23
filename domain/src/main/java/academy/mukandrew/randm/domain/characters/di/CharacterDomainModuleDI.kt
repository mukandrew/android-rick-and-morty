package academy.mukandrew.randm.domain.characters.di

import academy.mukandrew.randm.domain.characters.usecases.abstractions.GetCharacterListUseCase
import academy.mukandrew.randm.domain.characters.usecases.abstractions.GetCharacterUseCase
import academy.mukandrew.randm.domain.characters.usecases.abstractions.GetMultipleCharacterUseCase
import academy.mukandrew.randm.domain.characters.usecases.implementations.GetCharacterListUseCaseImpl
import academy.mukandrew.randm.domain.characters.usecases.implementations.GetCharacterUseCaseImpl
import academy.mukandrew.randm.domain.characters.usecases.implementations.GetMultipleCharacterUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface CharacterDomainModuleDI {

    @Binds
    fun bindGetCharacterListUseCase(
        getCharacterListUseCaseImpl: GetCharacterListUseCaseImpl
    ): GetCharacterListUseCase

    @Binds
    fun bindGetCharacterUseCase(
        getCharacterUseCaseImpl: GetCharacterUseCaseImpl
    ): GetCharacterUseCase

    @Binds
    fun bindGetMultipleCharacterUseCase(
        getMultipleCharacterUseCaseImpl: GetMultipleCharacterUseCaseImpl
    ): GetMultipleCharacterUseCase
}
