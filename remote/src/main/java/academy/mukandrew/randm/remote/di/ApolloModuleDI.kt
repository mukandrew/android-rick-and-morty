package academy.mukandrew.randm.remote.di

import academy.mukandrew.randm.remote.graphql.ApolloService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApolloModuleDI {
    @Singleton
    @Provides
    fun provideApolloClient(): ApolloService = ApolloService()
}
