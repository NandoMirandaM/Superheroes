package com.nandomiranda.superheros.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.nandomiranda.superheros.R
import com.nandomiranda.superheros.databinding.FragmentHeroDetailBinding
import com.nandomiranda.superheros.model.superhero.Superhero

class HeroDetailFragment : Fragment() {

    private val args: HeroDetailFragmentArgs by navArgs()

    private lateinit var name:TextView
    private lateinit var intel:TextView
    private lateinit var strength:TextView
    private lateinit var speed:TextView
    private lateinit var durab:TextView
    private lateinit var power:TextView
    private lateinit var combat:TextView
    private lateinit var fullname:TextView
    private lateinit var placeBirth:TextView
    private lateinit var appe:TextView
    private lateinit var publisher:TextView
    private lateinit var gender:TextView
    private lateinit var race:TextView
    private lateinit var heigth:TextView
    private lateinit var weight:TextView
    private lateinit var eye:TextView
    private lateinit var hair:TextView
    private lateinit var occupa:TextView
    private lateinit var base:TextView
    private lateinit var affi:TextView
    private lateinit var relati:TextView
    private lateinit var image:ImageView

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHeroDetailBinding.inflate(inflater,container,false)
        val superhero = args.superhero
        name = binding.tvName
        intel = binding.tvIntel
        strength = binding.tvStrength
        speed = binding.tvSpeed
        durab = binding.tvDurability
        power = binding.tvPower
        combat = binding.tvCombat
        fullname = binding.tvFullname
        placeBirth = binding.tvPlaceBirth
        appe = binding.tvAppearance
        publisher = binding.tvPublisher
        gender = binding.tvGender
        race = binding.tvRace
        heigth = binding.tvHeight
        weight = binding.tvWeight
        eye = binding.tvEyeColor
        hair = binding.tvHairColor
        occupa = binding.tvOccupation
        base = binding.tvBase
        affi = binding.tvAffiliation
        relati = binding.tvRelatives
        image = binding.urlImage

        setSuperheroData(superhero)

        return binding.root
    }

    private fun setSuperheroData(superhero: Superhero)
    {
        Glide.with(this).load(superhero.image_Url).into(image)
        name.text = superhero.name
        intel.text = superhero.power_int
        strength.text = superhero.power_stre
        speed.text = superhero.power_speed
        durab.text = superhero.power_durab
        power.text = superhero.power_power
        combat.text = superhero.power_combat
        fullname.text = superhero.fullname
        placeBirth.text = superhero.bio_placeBirth
        appe.text = superhero.bio_appearance
        publisher.text = superhero.bio_publisher
        gender.text = superhero.appe_gender
        race.text = superhero.appe_race
        heigth.text = superhero.appe_height
        weight.text = superhero.appe_weight
        eye.text = superhero.appe_eyeColor
        hair.text = superhero.appe_hairColor
        occupa.text = superhero.work_occupation
        base.text = superhero.work_base
        affi.text = superhero.connec_affiliation
        relati.text = superhero.connec_relatives
    }

}