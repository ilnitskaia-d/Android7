package com.example.android7.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android7.data.database.dao.ItemDao
import com.example.android7.data.database.model.Item

@Database(entities = [Item::class], [], 1, true)
abstract class ItemDatabase: RoomDatabase() {
    abstract fun getDao(): ItemDao
}