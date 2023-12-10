package com.example.android7.domain.repositories

import com.example.android7.data.database.model.Item

interface ItemRepository {

    suspend fun getAllItems(): List<Item>

    suspend fun insertItem(item: Item)

    suspend fun updateItem(item: Item)

    suspend fun deleteItem(item: Item)
}