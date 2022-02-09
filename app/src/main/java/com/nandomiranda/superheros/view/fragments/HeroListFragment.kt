package com.nandomiranda.superheros.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.nandomiranda.superheros.databinding.FragmentHeroListBinding
import com.nandomiranda.superheros.model.superhero.Superhero
import com.nandomiranda.superheros.model.superhero.superheroAdapter

class HeroListFragment : Fragment() {

    private lateinit var binding: FragmentHeroListBinding

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        //iniciamos binding
        binding = FragmentHeroListBinding.inflate(inflater, container,false)

        //se crea el RecyclerView
        val recyclerView = binding.heroRecycler
        recyclerView.layoutManager= GridLayoutManager(requireActivity(),2)

        val heroList = mutableListOf<Superhero>()
        heroList.add(
            Superhero(70,"Batman",100,70,90,70,99,100,
            "Bruce Wayne","Gotica","un comic","Dc","male","Human",
            "188 cm","75 kg", "blue","black","Businessman","Batcave",
            "Family Batman","Wayne Family","https://www.superherodb.com/pictures2/portraits/10/100/639.jpg")
        )
        heroList.add(
            Superhero(70,"Batman",100,70,90,70,99,100,
                "Bruce Wayne","Gotica","un comic","Dc","male","Human",
                "188 cm","75 kg", "blue","black","Businessman","Batcave",
                "Family Batman","Wayne Family","https://www.superherodb.com/pictures2/portraits/10/100/639.jpg")
        )
        heroList.add(
            Superhero(70,"Batman",100,70,90,70,99,100,
                "Bruce Wayne","Gotica","un comic","Dc","male","Human",
                "188 cm","75 kg", "blue","black","Businessman","Batcave",
                "Family Batman","Wayne Family","https://www.superherodb.com/pictures2/portraits/10/100/639.jpg")
        )
        heroList.add(
            Superhero(70,"Batman",100,70,90,70,99,100,
                "Bruce Wayne","Gotica","un comic","Dc","male","Human",
                "188 cm","75 kg", "blue","black","Businessman","Batcave",
                "Family Batman","Wayne Family","https://www.superherodb.com/pictures2/portraits/10/100/639.jpg")
        )
        heroList.add(
            Superhero(70,"Batman",100,70,90,70,99,100,
                "Bruce Wayne","Gotica","un comic","Dc","male","Human",
                "188 cm","75 kg", "blue","black","Businessman","Batcave",
                "Family Batman","Wayne Family","https://www.superherodb.com/pictures2/portraits/10/100/639.jpg")
        )
        heroList.add(
            Superhero(70,"Batman",100,70,90,70,99,100,
                "Bruce Wayne","Gotica","un comic","Dc","male","Human",
                "188 cm","75 kg", "blue","black","Businessman","Batcave",
                "Family Batman","Wayne Family","https://www.superherodb.com/pictures2/portraits/10/100/639.jpg")
        )
        heroList.add(
            Superhero(70,"Batman",100,70,90,70,99,100,
                "Bruce Wayne","Gotica","un comic","Dc","male","Human",
                "188 cm","75 kg", "blue","black","Businessman","Batcave",
                "Family Batman","Wayne Family","https://www.superherodb.com/pictures2/portraits/10/100/639.jpg")
        )
        heroList.add(
            Superhero(70,"Batman",100,70,90,70,99,100,
                "Bruce Wayne","Gotica","un comic","Dc","male","Human",
                "188 cm","75 kg", "blue","black","Businessman","Batcave",
                "Family Batman","Wayne Family","https://www.superherodb.com/pictures2/portraits/10/100/639.jpg")
        )
        heroList.add(
            Superhero(70,"Batman",100,70,90,70,99,100,
                "Bruce Wayne","Gotica","un comic","Dc","male","Human",
                "188 cm","75 kg", "blue","black","Businessman","Batcave",
                "Family Batman","Wayne Family","https://www.superherodb.com/pictures2/portraits/10/100/639.jpg")
        )
        heroList.add(
            Superhero(70,"Batman",100,70,90,70,99,100,
                "Bruce Wayne","Gotica","un comic","Dc","male","Human",
                "188 cm","75 kg", "blue","black","Businessman","Batcave",
                "Family Batman","Wayne Family","https://www.superherodb.com/pictures2/portraits/10/100/639.jpg")
        )
        heroList.add(
            Superhero(70,"Batman",100,70,90,70,99,100,
                "Bruce Wayne","Gotica","un comic","Dc","male","Human",
                "188 cm","75 kg", "blue","black","Businessman","Batcave",
                "Family Batman","Wayne Family","https://www.superherodb.com/pictures2/portraits/10/100/639.jpg")
        )

        val adapter = superheroAdapter()
        binding.heroRecycler.adapter = adapter
        adapter.submitList(heroList)

        adapter.onItemClickListener = {
            Toast.makeText(requireActivity(),it.name, Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}