package com.kotlin.museamproject.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PictureObject(
        @Expose @SerializedName("objectID") val objectID: Int,
        @Expose @SerializedName("primaryImage") val primaryImage: String?,
        @Expose @SerializedName("primaryImageSmall") val primaryImageSmall: String? = null,
        @Expose val title: String? = null,
        @Expose @SerializedName("artistDisplayName") val artistDisplayName: String? = null
) : Parcelable