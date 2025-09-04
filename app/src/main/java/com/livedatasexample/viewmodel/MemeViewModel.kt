package com.livedatasexample.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.livedatasexample.model.DogsResponse
import com.livedatasexample.model.Meme
import com.livedatasexample.model.MemeResponse
import com.livedatasexample.model.PhotosResponse
import com.livedatasexample.repository.MemeRepository
import com.livedatasexample.utils.ApiResponseCallBack
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemeViewModel @Inject constructor(private val memeRepository: MemeRepository) : ViewModel(){

    private val _meme = MutableStateFlow<ApiResponseCallBack<List<PhotosResponse>>?>(null)
    val meme : StateFlow<ApiResponseCallBack<List<PhotosResponse>>?> = _meme

    fun getMeme(page : Int ,limit : Int) {
       viewModelScope.launch {
             memeRepository.getMeme(page ,limit).collect {
                 _meme.value = it
             }
       }
    }

    private val _dataDogs = MutableStateFlow<ApiResponseCallBack<DogsResponse>?>(null)
    val dataDogs : StateFlow<ApiResponseCallBack<DogsResponse>?> =_dataDogs

    fun getDataDogs() {
        viewModelScope.launch {
            memeRepository.getDogs()
            Log.d("12345", "getDataDogs: ")
        }
    }
}