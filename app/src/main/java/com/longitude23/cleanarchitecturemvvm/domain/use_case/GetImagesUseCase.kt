package com.longitude23.cleanarchitecturemvvm.domain.use_case

import com.longitude23.cleanarchitecturemvvm.common.Resource
import com.longitude23.cleanarchitecturemvvm.data.remote.dto.toImages
import com.longitude23.cleanarchitecturemvvm.domain.model.Images
import com.longitude23.cleanarchitecturemvvm.domain.repository.ImagesRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val repository: ImagesRepository
) {
    operator fun invoke(): kotlinx.coroutines.flow.Flow<Resource<List<Images>>> = flow {
        try {
            emit(Resource.Loading<List<Images>>())
            val images = repository.getImages().map { it.toImages() }
            emit(Resource.Success<List<Images>>(images))

        } catch (e: HttpException) {
            emit(
                Resource.Error<List<Images>>(
                    e.localizedMessage ?: "An unexpected error occurred "
                )
            )

        } catch (e: IOException) {
            emit(Resource.Error<List<Images>>("Couldn't reach server. Check your Internet Connection"))
        }
    }
}