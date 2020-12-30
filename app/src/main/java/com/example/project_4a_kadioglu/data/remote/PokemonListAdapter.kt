package com.example.project_4a_kadioglu.data.remote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project_4a_kadioglu.R
import com.example.project_4a_kadioglu.data.repository.Pokemon



class PokemonListAdapter(internal var context: Context, private var pokemonList:List<Pokemon>):RecyclerView.Adapter<PokemonListAdapter.myViewHolder>()
{
     inner class myViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
     {
         internal var img_pokemon:ImageView
         internal var txt_pokemon:TextView
         init {
             img_pokemon=itemView.findViewById(R.id.pokemon_image) as ImageView
             txt_pokemon=itemView.findViewById(R.id.pokemon_name) as TextView
         }

     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.pokemon_list_item,parent,false)
        return myViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        Glide.with(context).load(pokemonList[position].img).into(holder.img_pokemon)
        holder.txt_pokemon.text =pokemonList[position].name
    }
}