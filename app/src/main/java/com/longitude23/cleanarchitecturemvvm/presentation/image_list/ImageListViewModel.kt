package com.longitude23.cleanarchitecturemvvm.presentation.image_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.longitude23.cleanarchitecturemvvm.common.Resource
import com.longitude23.cleanarchitecturemvvm.domain.use_case.GetImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(

    private val getImagesUseCase: GetImagesUseCase

) : ViewModel() {

    val state = MutableLiveData(ImageListState())

    init {
        getImages()
    }

    private fun getImages() {
        getImagesUseCase().onEach { result ->
            when (result) {
                is Resource.Success<*> -> {
                    this.state.value = ImageListState(images = result.data ?: emptyList())
                }
                is Resource.Error<*> -> {
                    state.value = ImageListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading<*> -> {
                    state.value = ImageListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }


}