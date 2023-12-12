package com.example.android7.di

import android.content.Context
import androidx.room.Room
import com.example.android7.data.database.ItemDatabase
import com.example.android7.data.database.dao.ItemDao
import com.example.android7.data.database.repositories.ItemRepositoryImp
import com.example.android7.domain.repositories.ItemRepository
import com.example.android7.domain.usecase.GetAllItemsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRoomDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ItemDatabase::class.java, "item_db")

    @Provides
    fun provideItemDao(database: ItemDatabase) =
        database.getDao()

    @Provides
    fun provideItemRepository(dao: ItemDao) =
        ItemRepositoryImp(dao)

    @Provides
    fun provideGetAllItemsUseCase(repository: ItemRepository) =
        GetAllItemsUseCase(repository)
}