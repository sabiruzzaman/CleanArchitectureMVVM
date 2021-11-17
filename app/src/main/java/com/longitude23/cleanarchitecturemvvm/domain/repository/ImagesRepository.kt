package com.longitude23.cleanarchitecturemvvm.domain.repository

import com.longitude23.cleanarchitecturemvvm.data.remote.dto.ImagesDto

interface ImagesRepository {
    suspend fun getImages(): List<ImagesDto>
}