package com.example.dogssearchengine.api

import com.example.dogssearchengine.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DogApi {

    companion object {

        //base url link to send a request on
        const val BASE_URL = "https://api.unsplash.com/"
        //generate the api key added to gradle files
        const val CLIENT_ID = BuildConfig.UNSPLASH_ACCESS_KEY
    }

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")

    //handling threading with kotlin Coroutines
    //function can be paused and resumed later on
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): SearchResponse
}