package com.example.android7.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.android7.data.database.model.Item
import com.example.android7.domain.model.ItemModel
import com.example.android7.domain.utils.Resource

@Dao
interface ItemDao {

    @Query("SELECT * FROM 'item-table' ")
    suspend fun getAllItems(): List<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)

}