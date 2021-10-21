package com.example.filmlerkotlinbootcamp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlerkotlinbootcamp.databinding.CardFilmBinding
import com.example.filmlerkotlinbootcamp.databinding.FragmentDetailBinding
import com.example.filmlerkotlinbootcamp.model.Film
import com.example.filmlerkotlinbootcamp.view.FilmFragmentDirections
import com.squareup.picasso.Picasso

class FilmAdapter(var mContext:Context,var filmList:ArrayList<Film>):RecyclerView.Adapter<FilmAdapter.FilmHolder>() {
    inner class FilmHolder(var cardFilmBinding: CardFilmBinding):RecyclerView.ViewHolder(cardFilmBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val view=CardFilmBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return FilmHolder(view)
    }

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        val film=filmList[position]
        holder.cardFilmBinding.apply {
            textViewCardFilm.text=film.filmAd
            Picasso.get().load("http://kasimadalan.pe.hu/filmler/resimler/${film.filmResim}").into(imageViewCard)
            cardFilm.setOnClickListener {
                val action=FilmFragmentDirections.actionFilmFragmentToDetailFragment(film)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return filmList.size
    }
}