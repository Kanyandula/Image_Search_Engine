package com.example.dogssearchengine.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DogImages(
    val id: String,
    val description: String?,
    val urls: ImageUrls,
    val likes: Int,
    val user: Users


) : Parcelable

@Parcelize
data class ImageUrls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
) : Parcelable



@Parcelize
data class Users(
    val name: String,
    val username: String
) : Parcelable {
    val attributionUrl get() = "https://unsplash.com/$username?utm_source=ImageSearchApp&utm_medium=referral"

}
