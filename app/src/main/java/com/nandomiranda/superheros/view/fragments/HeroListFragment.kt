package com.nandomiranda.superheros.view.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nandomiranda.superheros.databinding.FragmentHeroListBinding
import com.nandomiranda.superheros.model.api.ApiResponseStatus
import com.nandomiranda.superheros.model.superhero.Superhero
import com.nandomiranda.superheros.model.superhero.superheroAdapter
import com.nandomiranda.superheros.viewModel.HeroLVMFactory
import com.nandomiranda.superheros.viewModel.HeroListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        val viewModel = ViewModelProvider(this, HeroLVMFactory(requireActivity().application)).get(HeroListViewModel::class.java)

        //asignamos el adapter al recyclerview
        val adapter = superheroAdapter()
        binding.heroRecycler.adapter = adapter

        //observer para los cambios de las lista
        viewModel.superheroList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        //paginaci??n de recyclerView
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView , newState: Int) {
                super.onScrollStateChanged(recyclerView , newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {

                    viewModel.viewModelScope.launch {
                        viewModel.newSuperheroes()
                    }
                }
            }
        })

        viewModel.status.observe(requireActivity(), Observer {
            apiResponseStatus ->
            if (apiResponseStatus == ApiResponseStatus.LOADING){
                binding.rlProgressbar.visibility = View.VISIBLE
            }else if(apiResponseStatus == ApiResponseStatus.DONE){
                binding.rlProgressbar.visibility = View.GONE
            }else if (apiResponseStatus == ApiResponseStatus.ERROR){
                binding.rlProgressbar.visibility = View.GONE
                Toast.makeText(requireContext(),"Requiere conexi??n a Internet",Toast.LENGTH_SHORT).show()
            }
        })

        adapter.onItemClickListener={
            superheroSelectListener.onSuperheroSelected(it)
        }

        return binding.root
    }
}