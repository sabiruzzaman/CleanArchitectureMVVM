package com.longitude23.cleanarchitecturemvvm.presentation.image_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.longitude23.cleanarchitecturemvvm.databinding.FragmentImageListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageListFragment : Fragment() {

    lateinit var binding: FragmentImageListBinding
    lateinit var adapter: ImageListAdapter
    private val viewModel: ImageListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentImageListBinding.inflate(layoutInflater)
        binding.root.setOnClickListener {
            return@setOnClickListener
        }
        viewInit()
        return binding.root
    }

    private fun viewInit() {
        adapter = ImageListAdapter(requireContext())
        binding.imageRvId.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.imageRvId.adapter = adapter
        subscribeObservers()
    }

    private fun subscribeObservers() {

        viewModel.state.observe(viewLifecycleOwner) {
            if (it.isLoading) {
                binding.progressBarId.visibility = View.VISIBLE
            } else {
                binding.progressBarId.visibility = View.GONE
            }
            if (it.images.isNotEmpty()) {
                adapter.submitList(it.images)
            }
        }



    }
}