package com.example.android7.data.database.repositories

import com.example.android7.data.database.dao.ItemDao
import com.example.android7.data.database.model.Item
import com.example.android7.domain.repositories.ItemRepository
import javax.inject.Inject

class ItemRepositoryImp @Inject constructor(
    private val dao: ItemDao
): ItemRepository {
    override suspend fun getAllItems(): List<Item> = dao.getAllItems()

    override suspend fun insertItem(item: Item) {
        dao.insertItem(item)
    }

    override suspend fun updateItem(item: Item) {
        dao.updateItem(item)
    }

    override suspend fun deleteItem(item: Item) {
        dao.deleteItem(item)
    }
}