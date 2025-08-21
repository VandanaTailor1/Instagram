package com.livedatasexample.repository

import com.livedatasexample.model.MemeResponse
import com.livedatasexample.model.PhotosResponse
import com.livedatasexample.network.ApiService
import com.livedatasexample.utils.ApiResponseCallBack
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MemeRepository @Inject constructor(private var apiService: ApiService) {

    fun getMeme(page : Int ,limit : Int): Flow<ApiResponseCallBack<List<PhotosResponse>>> =
        flow {
            emit(ApiResponseCallBack.loading())
            val response = apiService.getMemeData(page ,limit)
            emit(ApiResponseCallBack.success(response))
        }.catch {
            emit(ApiResponseCallBack.error(it.message.toString()))
        }. flowOn(Dispatchers.IO)

}