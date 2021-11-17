package com.longitude23.cleanarchitecturemvvm.di

import com.longitude23.cleanarchitecturemvvm.common.Constants
import com.longitude23.cleanarchitecturemvvm.data.remote.ImagesApi
import com.longitude23.cleanarchitecturemvvm.data.repository.ImagesRepositoryImpl
import com.longitude23.cleanarchitecturemvvm.domain.repository.ImagesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideImagesApi():ImagesApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create() )
            .build()
            .create(ImagesApi::class.java)
    }

    @Provides
    @Singleton
     fun provideImagesRepository(api: ImagesApi):ImagesRepository{
        return ImagesRepositoryImpl(api)
    }
}