package com.mc.kim.test.ui.viewModel

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mc.kim.remote.api.ResponseResult
import com.mc.kim.remote.util.Log
import com.mc.kim.test.R
import com.mc.kim.test.dao.obj.Image
import com.mc.kim.test.dao.response.WikiData
import com.mc.kim.test.dao.response.WikiDataList
import com.mc.kim.test.ui.repository.WikiRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.MalformedURLException

class SearchHomeViewModel internal constructor(
    private val wikiRepository: WikiRepository
) : ViewModel() {
    private val TAG = SearchHomeViewModel::class.simpleName!!


    private val _summary = MutableLiveData<ResponseResult<WikiData>>()
    val summaryData: LiveData<ResponseResult<WikiData>> get() = _summary
    private val _relatedDataList = MutableLiveData<ResponseResult<WikiDataList>>()
    val relatedData: LiveData<ResponseResult<WikiDataList>> get() = _relatedDataList
    private var currentKeyword:String = ""

    fun getCurrentKeyword(): String {
        return currentKeyword
    }

    fun getSearchResult(keyword: String) = viewModelScope.launch {
        currentKeyword = keyword
        _summary.value = wikiRepository.searchSummary(keyword)
    }

    fun getRelatedList(wikiData: WikiData) = viewModelScope.launch {
        _relatedDataList.value = wikiRepository.loadRelatedList(wikiData)
    }

    fun getCachedImage(resources: Resources, image: Image, result: (Bitmap?) -> Unit) {
        viewModelScope.launch {
            try {
                result(wikiRepository.loadImage(image))
            } catch (e: MalformedURLException) {
                result(null)
            }
        }
    }
}