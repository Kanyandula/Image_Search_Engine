package com.example.dogssearchengine.api

import com.example.dogssearchengine.data.DogImages

data class SearchResponse (
    val results: List<DogImages>
)