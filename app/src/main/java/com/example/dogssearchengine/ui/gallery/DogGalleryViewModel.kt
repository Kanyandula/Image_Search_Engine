package com.example.dogssearchengine.ui.gallery

import android.app.DownloadManager
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.example.dogssearchengine.data.DogRepository

class DogGalleryViewModel @ViewModelInject constructor(
    private val repository: DogRepository,
    @Assisted state: SavedStateHandle // allows us to save pieces of data through process death and can be restored after

) : ViewModel() {
    private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)


    val photos = currentQuery.switchMap { queryString ->

        //cache the live data to prevent a crush when we rotate the device
        repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }

    companion object {
        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = "dogs"
    }

}