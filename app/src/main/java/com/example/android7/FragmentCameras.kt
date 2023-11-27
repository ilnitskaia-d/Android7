package com.example.android7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android7.databinding.FragmentCamerasBinding
import com.example.android7.ui.main.Item
import com.example.android7.ui.main.PageViewModel
import com.example.android7.ui.main.RVAdapter

class FragmentCameras : Fragment() {
    lateinit var binding: FragmentCamerasBinding
    private val adapter by lazy { RVAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCamerasBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pageViewModel =  PageViewModel()

        adapter.submitList(pageViewModel.list.value)

        binding.rv.apply {
            adapter = this@FragmentCameras.adapter
            layoutManager = LinearLayoutManager(
                this@FragmentCameras.context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }

    }
}