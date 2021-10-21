package com.example.filmlerkotlinbootcamp.servis

import com.example.filmlerkotlinbootcamp.model.FilmCevap
import com.example.filmlerkotlinbootcamp.model.KategoriCeap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FilmDao {
    @GET("tum_kategoriler.php")
    fun tumKAtegori():Call<KategoriCeap>

    @POST("filmler_by_kategori_id.php")
    @FormUrlEncoded
    fun filmGetir(@Field("kategori_id") kid:Int):Call<FilmCevap>
}