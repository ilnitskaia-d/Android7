package com.example.android7.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.android7.databinding.ItemCameraBinding
import com.example.android7.databinding.SectionHeaderBinding


class RVAdapter: ListAdapter<CameraItem, RVAdapter.ItemViewHolder>(ItemDiffUtil()) {

    private val list: ArrayList<CameraItem> = arrayListOf()
    val VIEW_TYPE_HEADER = 0
    val VIEW_TYPE_ITEM = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            ItemViewHolder(
                ItemCameraBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            SectionHeaderViewHolder(SectionHeaderBinding.inflate(LayoutInflater.from(parent.context),parent, false))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder.itemViewType) {
            VIEW_TYPE_ITEM -> {
                val h = holder as ItemViewHolder
                h.bind(list[position])
            }

            VIEW_TYPE_HEADER -> {
                val h = holder as SectionHeaderViewHolder
                h.binding
            }
        }
    }

    inner class ItemViewHolder(private val binding: ItemCameraBinding):ViewHolder(binding.root) {
        fun bind(camera: CameraItem) {
            binding.tvCamera.text = camera.name
        }
    }

    inner class SectionHeaderViewHolder(private val binding: SectionHeaderBinding):ViewHolder(binding.root)

    class ItemDiffUtil: DiffUtil.ItemCallback<CameraItem>() {
        override fun areItemsTheSame(oldItem: CameraItem, newItem: CameraItem): Boolean = oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: CameraItem, newItem: CameraItem): Boolean = oldItem == newItem

    }
}
