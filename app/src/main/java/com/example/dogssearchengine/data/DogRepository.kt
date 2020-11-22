package com.example.dogssearchengine.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.dogssearchengine.api.DogApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogRepository @Inject constructor (private val dogApi: DogApi){

    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { DogPagingSource(dogApi, query) }
        ).liveData

}