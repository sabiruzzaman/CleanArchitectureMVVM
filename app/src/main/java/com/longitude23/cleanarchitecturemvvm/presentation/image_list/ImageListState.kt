package com.longitude23.cleanarchitecturemvvm.presentation.image_list

import com.longitude23.cleanarchitecturemvvm.domain.model.Images

data class ImageListState(
    val isLoading: Boolean = false,
    val images: List<Images> = emptyList(),
    val error: String = ""
)

