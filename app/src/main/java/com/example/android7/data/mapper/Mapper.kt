package com.example.android7.data.mapper

import com.example.android7.data.database.model.Item
import com.example.android7.domain.model.ItemModel

fun ItemModel.mapToItem() = Item(
    id = id,
    type = type,
    name = name,
    img = img
)

fun List<Item>.mapToItemModelList() = this.map {
    ItemModel(
        id = it.id,
        type = it.type,
        name = it.name,
        img = it.img
    )
}