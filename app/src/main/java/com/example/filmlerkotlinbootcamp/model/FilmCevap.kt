package com.example.filmlerkotlinbootcamp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FilmCevap(
	@Expose
	@field:SerializedName("success")
	val success: Int,
	@Expose
	@field:SerializedName("filmler")
	val filmler: List<Film>
)
