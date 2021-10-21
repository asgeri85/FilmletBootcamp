package com.example.filmlerkotlinbootcamp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.filmlerkotlinbootcamp.R
import com.example.filmlerkotlinbootcamp.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {
    private var _binding:FragmentDetailBinding?=null
    private val binding get() = _binding!!
    private val args:DetailFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            Picasso.get().load("http://kasimadalan.pe.hu/filmler/resimler/${args.film.filmResim}").into(imageViewDetail)
            textViewDetailAd.text=args.film.filmAd
            textViewYil.text=args.film.filmYil
            textViewYonetmen.text=args.film.yonetmen?.yonetmenAd
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}