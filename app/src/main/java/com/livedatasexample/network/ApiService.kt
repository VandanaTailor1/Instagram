package com.livedatasexample.network

import com.livedatasexample.model.DogsResponse
import com.livedatasexample.model.MemeResponse
import com.livedatasexample.model.PhotosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("photos")
    suspend fun getMemeData(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int
    ) : List<PhotosResponse>

    @GET("random")
    suspend fun getDogsData(): DogsResponse
}