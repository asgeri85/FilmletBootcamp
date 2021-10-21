package com.example.filmlerkotlinbootcamp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KategoriCeap(
    @Expose
    @SerializedName("kategoriler")
    var kategoriler:List<Kategori>,

    @Expose
    @SerializedName("success")
    var success: Int
)

