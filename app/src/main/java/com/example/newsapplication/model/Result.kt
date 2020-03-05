package com.example.newsapplication.model
    import android.os.Parcelable
    import kotlinx.android.parcel.Parcelize
    import kotlinx.serialization.*
    import kotlinx.serialization.json.*
    import kotlinx.serialization.internal.*

    @Parcelize
    @Serializable
    data class Welcome (
        val response: Response
    ):Parcelable

    @Parcelize
    @Serializable
    data class Response (
        val results: List<Result>
    ):Parcelable

    @Parcelize
    @Serializable
    data class Result (
        val webPublicationDate: String,
        val webTitle: String,
        @SerialName("webUrl")
        val webURL: String
    ):Parcelable
