package com.example.android7.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.android7.databinding.ItemCameraBinding


class RVAdapter: ListAdapter<Item, RVAdapter.ItemViewHolder>(ItemDiffUtil()) {

    private val list: ArrayList<Item> = arrayListOf()
    val VIEW_TYPE_HEADER = "header"
    val VIEW_TYPE_ITEM = "item"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
                ItemCameraBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ItemViewHolder(private val binding: ItemCameraBinding):ViewHolder(binding.root) {
        fun bind(camera: Item) {
            binding.tvCamera.text = camera.name
            when (camera.type) {
                VIEW_TYPE_HEADER -> {
                    binding.ivCamera.visibility = View.GONE
                }
                VIEW_TYPE_ITEM -> {
                    binding.ivCamera.visibility = View.VISIBLE
                }
            }
        }
    }

    class ItemDiffUtil: DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem

    }
}
