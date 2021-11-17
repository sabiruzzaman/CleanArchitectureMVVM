package com.longitude23.cleanarchitecturemvvm.data.remote

import com.longitude23.cleanarchitecturemvvm.data.remote.dto.ImagesDto
import retrofit2.http.GET

interface ImagesApi {

    @GET("v2/list")
    suspend fun getImages(): List<ImagesDto>

}