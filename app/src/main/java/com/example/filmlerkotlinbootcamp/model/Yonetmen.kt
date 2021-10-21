package com.example.filmlerkotlinbootcamp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Yonetmen(
    @Expose
    @field:SerializedName("yonetmen_ad")
    val yonetmenAd: String? = null,
    @Expose
    @field:SerializedName("yonetmen_id")
    val yonetmenId: String? = null
):Parcelable