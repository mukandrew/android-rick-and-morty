package academy.mukandrew.randm.remote.characters.di

import academy.mukandrew.randm.data.characters.datasource.CharacterDataSource
import academy.mukandrew.randm.data.characters.di.CharacterRemoteDataSourceQualifier
import academy.mukandrew.randm.remote.characters.datasource.CharacterRemoteDataSource
import academy.mukandrew.randm.remote.graphql.clients.CharacterClient
import academy.mukandrew.randm.remote.graphql.clients.CharacterClientImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface CharacterRemoteModuleDI {
    @Binds
    fun bindCharacterClient(characterClientImpl: CharacterClientImpl): CharacterClient

    @CharacterRemoteDataSourceQualifier
    @Binds
    fun bindCharacterRemoteDataSource(
        characterRemoteDataSource: CharacterRemoteDataSource
    ): CharacterDataSource
}
