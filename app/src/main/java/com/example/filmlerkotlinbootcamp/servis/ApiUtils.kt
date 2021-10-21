package com.example.filmlerkotlinbootcamp.servis

class ApiUtils {
    companion object{
        const val URL="http://kasimadalan.pe.hu/filmler/"
        fun getFilmDao():FilmDao{
            return RetorfitClient.getRetrofit(URL).create(FilmDao::class.java)
        }
    }
}