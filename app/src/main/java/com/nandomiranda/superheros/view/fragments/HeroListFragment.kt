package com.nandomiranda.superheros.view.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.nandomiranda.superheros.databinding.FragmentHeroListBinding
import com.nandomiranda.superheros.model.superhero.Superhero
import com.nandomiranda.superheros.model.superhero.superheroAdapter
import com.nandomiranda.superheros.viewModel.HeroListViewModel
import java.lang.ClassCastException

class HeroListFragment : Fragment() {

    private lateinit var binding: FragmentHeroListBinding

    interface  SuperheroSelectListener {
        fun onSuperheroSelected(superhero: Superhero)
    }

    private lateinit var superheroSelectListener: SuperheroSelectListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        superheroSelectListener = try {
            context as SuperheroSelectListener
        }catch (e: ClassCastException){
            throw ClassCastException("$context must implement SuperheroSelectListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        //iniciamos binding
        binding = FragmentHeroListBinding.inflate(inflater, container,false)

        //se crea el RecyclerView
        val recyclerView = binding.heroRecycler
        recyclerView.layoutManager= GridLayoutManager(requireActivity(),2)

        //variable ViewModel
        val viewModel = ViewModelProvider(this).get(HeroListViewModel::class.java)

        //asignamos el adapter al recyclerview
        val adapter = superheroAdapter()
        binding.heroRecycler.adapter = adapter

        //observer para los cambios de las lista
        viewModel.superheroList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        adapter.onItemClickListener = {
            Toast.makeText(requireActivity(),it.name, Toast.LENGTH_SHORT).show()
        }

        adapter.onItemClickListener={
            superheroSelectListener.onSuperheroSelected(it)
            // Toast.makeText(requireActivity(),it.title, Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}