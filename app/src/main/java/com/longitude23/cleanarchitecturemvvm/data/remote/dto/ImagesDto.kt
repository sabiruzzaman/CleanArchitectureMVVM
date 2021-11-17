package com.longitude23.cleanarchitecturemvvm.data.remote.dto

import com.longitude23.cleanarchitecturemvvm.domain.model.Images

data class ImagesDto(
    val author: String,
    val download_url: String,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)

fun ImagesDto.toImages(): Images {
    return Images(
        author = author,
        download_url = download_url,
        height = height,
        id = id,
        url = url,
        width = width
    )
}
