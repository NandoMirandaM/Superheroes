package com.nandomiranda.superheros.model.superhero

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.nandomiranda.superheros.R
import com.nandomiranda.superheros.databinding.SuperheroListItemBinding

class superheroAdapter : ListAdapter<Superhero,superheroAdapter.ViewHolder>(DiffCallBack){

    //metodos para saber que item se quito y cual se agrego al recyclerView
    companion object DiffCallBack: DiffUtil.ItemCallback<Superhero>(){
        override fun areItemsTheSame(oldItem: Superhero , newItem: Superhero): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Superhero , newItem: Superhero): Boolean {
            return oldItem == newItem
        }
    }

    //lambda que regresa un superhero al darle click a un item, se inicializara desde HeroListFragment
    lateinit var onItemClickListener: (Superhero) -> Unit

    //los metodos onCreateViewHolder y onBindViewHolder se manda llamar para cada elemento de la lista
    //crea un viewHolder para cada elemento de la lista
    override fun onCreateViewHolder(
        parent: ViewGroup ,
        viewType: Int
    ): superheroAdapter.ViewHolder {
        val binding = SuperheroListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

        //se obtiene la posicion del elemento para pintarlo en pantalla
    override fun onBindViewHolder(holder: superheroAdapter.ViewHolder , position: Int) {
        val superhero = getItem(position)
        holder.bind(superhero)
    }


    //clase que trabaja los view del superhero_list_item
    inner class ViewHolder (private val binding: SuperheroListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun  bind(superhero: Superhero){
            binding.heroName.text = superhero.name
            Glide.with(binding.heroImage.context).load(superhero.image_Url).listener(object :
                RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException? ,
                    model: Any? ,
                    target: Target<Drawable>? ,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.heroImage.setImageResource(R.drawable.ic_baseline_image_not_supported) ///este solo es por si la app va a tronar
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable? ,
                    model: Any? ,
                    target: Target<Drawable>? ,
                    dataSource: DataSource? ,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

            }).error(R.drawable.ic_baseline_image_not_supported).into(binding.heroImage)

            //metodo para mandar llamar el lambda al hacer click en cualquier parte del elemento
            binding.root.setOnClickListener {
                if(::onItemClickListener.isInitialized){
                    onItemClickListener(superhero)
                }else{
                    Log.e("SuperheroAdapter","onItemClickListener no inicializado")
                }
            }

            binding.executePendingBindings()
        }
    }
}