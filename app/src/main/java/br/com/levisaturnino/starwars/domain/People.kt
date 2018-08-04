package br.com.levisaturnino.starwars.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class People (
        @Expose
    @SerializedName("url")
     val url: String? = null,
    @Expose
    @SerializedName("edited")
     val edited: String? = null,
    @Expose
    @SerializedName("created")
     val created: String? =null,
    @Expose
    @SerializedName("starships")
     val starships: List<String>? =null,
    @Expose
    @SerializedName("vehicles")
     val vehicles: List<String>? =null,
    @Expose
    @SerializedName("species")
     val species: List<String>? =null,
    @Expose
    @SerializedName("films")
     val films: List<String>? =null,
    @Expose
    @SerializedName("homeworld")
     val homeworld: String? =null,
    @Expose
    @SerializedName("gender")
     val gender: String? =null,
    @Expose
    @SerializedName("birth_year")
     val birth_year: String? =null,
    @Expose
    @SerializedName("eye_color")
     val eye_color: String? =null,
    @Expose
    @SerializedName("skin_color")
     val skin_color: String? =null,
    @Expose
    @SerializedName("hair_color")
     val hair_color: String? =null,
    @Expose
    @SerializedName("mass")
     val mass: String? =null,
    @Expose
    @SerializedName("height")
     val height: String? =null,
    @Expose
    @SerializedName("name")
     val name: String? = null
)