package academy.mukandrew.randm.cache.di

import academy.mukandrew.randm.cache.database.ApplicationDatabase
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModuleDI {

    @Provides
    @Singleton
    fun provideApplicationDataBase(
        @ApplicationContext applicationContext: Context
    ): ApplicationDatabase {
        return ApplicationDatabase.getDatabaseInstance(applicationContext)
    }
}
