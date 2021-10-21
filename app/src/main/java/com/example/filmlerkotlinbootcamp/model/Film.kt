package com.example.filmlerkotlinbootcamp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    @Expose
    @field:SerializedName("film_ad")
    val filmAd: String? = null,

    @Expose
    @field:SerializedName("yonetmen")
    val yonetmen: Yonetmen? = null,

    @Expose
    @field:SerializedName("film_resim")
    val filmResim: String? = null,

    @Expose
    @field:SerializedName("kategori")
    val kategori: Kategori? = null,

    @Expose
    @field:SerializedName("film_id")
    val filmId: String? = null,

    @Expose
    @field:SerializedName("film_yil")
    val filmYil: String? = null
) : Parcelable
