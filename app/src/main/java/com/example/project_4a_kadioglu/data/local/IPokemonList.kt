package com.example.project_4a_kadioglu.data.local


import com.example.project_4a_kadioglu.data.local.models.Pokedex
import io.reactivex.Observable

import retrofit2.http.GET

interface IPokemonList {
    @get:GET("pokedex.json")
    val listPokemon: Observable<Pokedex>
}