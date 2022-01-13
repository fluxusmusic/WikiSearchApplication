package com.mc.kim.test.ui.viewModel

import android.content.res.Resources
import android.graphics.Bitmap
import androidx.lifecycle.*
import com.mc.kim.remote.api.ResponseResult
import com.mc.kim.test.dao.obj.Image
import com.mc.kim.test.dao.response.WikiData
import com.mc.kim.test.dao.response.WikiDataList
import com.mc.kim.test.ui.repository.WikiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.MalformedURLException
import javax.inject.Inject

@HiltViewModel
class SearchHomeViewModel @Inject constructor(
    private val wikiRepository: WikiRepository,
    private val savedStateHandle: SavedStateHandle
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