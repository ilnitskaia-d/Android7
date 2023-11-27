package com.example.android7.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android7.databinding.FragmentCamerasBinding
import com.example.android7.ui.model.Item
import com.example.android7.ui.adapter.RVAdapter

class FragmentCameras : Fragment() {
    lateinit var binding: FragmentCamerasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCamerasBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvAdapter = RVAdapter(
            listOf(
                Item("header", "Гостинная", ""),
                Item("item", "Камера 1", ""),
                Item("item", "Камера 2", ""),
                Item("header", "Спальня", ""),
                Item("item", "Камера 3", ""),
                Item("item", "Камера 4", ""),
                Item("item", "Камера 5", ""),
            )
        )

        binding.rv.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(
                this@FragmentCameras.context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }

    }
}