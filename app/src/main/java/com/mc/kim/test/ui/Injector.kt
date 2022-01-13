package com.mc.kim.test.ui

import android.content.Context
import com.mc.kim.test.dao.WikiDataManager
import com.mc.kim.test.ui.repository.WikiRepository
import dagger.hilt.android.AndroidEntryPoint

//interface ViewModelFactoryProvider {
//    fun provideSearchHomeViewModelFactory(context: Context): SearchHomeViewModelFactory
//}
//
//val Injector: ViewModelFactoryProvider
//    get() = currentInjector
//
//private object DefaultViewModelProvider : ViewModelFactoryProvider {
//    private fun getWikiRepository(): WikiRepository {
//        return WikiRepository.getInstance(
//            wikiDataManager()
//        )
//    }
//
//    private fun wikiDataManager() = WikiDataManager()
//
//    override fun provideSearchHomeViewModelFactory(context: Context): SearchHomeViewModelFactory {
//        val repository = getWikiRepository()
//        return SearchHomeViewModelFactory(repository)
//    }
//}
//
//@Volatile
//private var currentInjector: ViewModelFactoryProvider =
//    DefaultViewModelProvider
