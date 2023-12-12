package com.example.android7.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item-table")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val type: String,
    val name: String,
    val img: String,
)
