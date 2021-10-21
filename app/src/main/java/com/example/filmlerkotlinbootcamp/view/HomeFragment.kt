package com.example.filmlerkotlinbootcamp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmlerkotlinbootcamp.adapters.KategoriAdapter
import com.example.filmlerkotlinbootcamp.databinding.FragmentHomeBinding
import com.example.filmlerkotlinbootcamp.model.Kategori
import com.example.filmlerkotlinbootcamp.model.KategoriCeap
import com.example.filmlerkotlinbootcamp.servis.ApiUtils
import com.example.filmlerkotlinbootcamp.servis.FilmDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private lateinit var dao:FilmDao
    private lateinit var kategoriList:ArrayList<Kategori>
    private lateinit var adapter: KategoriAdapter
    private var _binding:FragmentHomeBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dao=ApiUtils.getFilmDao()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvKategori.layoutManager=LinearLayoutManager(context)
        binding.rvKategori.setHasFixedSize(true)
        kategoriGetir()
    }

    fun kategoriGetir(){
        kategoriList= ArrayList()
        dao.tumKAtegori().enqueue(object :Callback<KategoriCeap>{
            override fun onResponse(call: Call<KategoriCeap>, response: Response<KategoriCeap>) {
               val liste=response.body()?.kategoriler
                liste?.let {
                    kategoriList=it as ArrayList<Kategori>
                }
                adapter= KategoriAdapter(requireContext(),kategoriList)
                binding.rvKategori.adapter=adapter
            }

            override fun onFailure(call: Call<KategoriCeap>, t: Throwable) {}
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}