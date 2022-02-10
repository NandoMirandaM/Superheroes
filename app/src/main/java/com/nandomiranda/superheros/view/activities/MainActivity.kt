package com.nandomiranda.superheros.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.nandomiranda.superheros.R
import com.nandomiranda.superheros.databinding.ActivityMainBinding
import com.nandomiranda.superheros.model.superhero.Superhero
import com.nandomiranda.superheros.view.fragments.HeroListFragment
import com.nandomiranda.superheros.view.fragments.HeroListFragmentDirections


class MainActivity : AppCompatActivity(), HeroListFragment.SuperheroSelectListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSuperheroSelected(superhero: Superhero){
        findNavController(R.id.main_navigation_container).navigate(HeroListFragmentDirections.actionHeroListFragmentToHeroDetailFragment(superhero))
    }
}