package com.example.filmlerkotlinbootcamp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmlerkotlinbootcamp.R
import com.example.filmlerkotlinbootcamp.adapters.FilmAdapter
import com.example.filmlerkotlinbootcamp.databinding.FragmentFilmBinding
import com.example.filmlerkotlinbootcamp.model.Film
import com.example.filmlerkotlinbootcamp.model.FilmCevap
import com.example.filmlerkotlinbootcamp.servis.ApiUtils
import com.example.filmlerkotlinbootcamp.servis.FilmDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmFragment : Fragment() {
    private var _binding:FragmentFilmBinding?=null
    private val binding get() = _binding!!
    private val args:FilmFragmentArgs by navArgs()
    private lateinit var dao:FilmDao
    private lateinit var adapter:FilmAdapter
    private lateinit var filmler:ArrayList<Film>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentFilmBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dao=ApiUtils.getFilmDao()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarFilm.title=args.kategori.kategoriAd
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarFilm)
        binding.rvFilm.layoutManager= GridLayoutManager(context,2)
        binding.rvFilm.setHasFixedSize(true)
        filmGetir(args.kategori.kategoriId!!.toInt())
    }

    fun filmGetir(id:Int){
        filmler= ArrayList()
        dao.filmGetir(id).enqueue(object :Callback<FilmCevap>{
            override fun onResponse(call: Call<FilmCevap>, response: Response<FilmCevap>) {
                val list=response.body()?.filmler
                list?.let {
                    filmler=it as ArrayList<Film>
                }
                adapter= FilmAdapter(requireContext(),filmler)
                binding.rvFilm.adapter=adapter
            }

            override fun onFailure(call: Call<FilmCevap>, t: Throwable) {

            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}