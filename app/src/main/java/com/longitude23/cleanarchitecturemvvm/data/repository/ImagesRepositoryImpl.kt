package com.longitude23.cleanarchitecturemvvm.data.repository

import com.longitude23.cleanarchitecturemvvm.data.remote.ImagesApi
import com.longitude23.cleanarchitecturemvvm.data.remote.dto.ImagesDto
import com.longitude23.cleanarchitecturemvvm.domain.repository.ImagesRepository
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor(
    private val api: ImagesApi
) : ImagesRepository {

    override suspend fun getImages(): List<ImagesDto> {
        return api.getImages()
    }
}