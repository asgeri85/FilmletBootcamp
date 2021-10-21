package com.example.filmlerkotlinbootcamp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kategori(
    @Expose
    @field:SerializedName("kategori_id")
    val kategoriId: String? = null,

    @Expose
    @field:SerializedName("kategori_ad")
    val kategoriAd: String? = null
):Parcelable

