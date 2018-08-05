package br.com.levisaturnino.starwars.domain

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class People(

        @Expose

        @PrimaryKey(autoGenerate = true)
        var id: Int? = null,
        @Expose
        @SerializedName("url")
        var url: String? = "",
        @Expose
        @SerializedName("edited")
        var edited: String? = "",
        @Expose
        @SerializedName("created")
        var created: String? = "",
        @Expose
        @Ignore
        @SerializedName("starships")
        var starships:  List<String>? = null,
        @Expose
        @Ignore
        @SerializedName("vehicles")
        var vehicles:  List<String>? = null,
        @Expose
        @Ignore
        @SerializedName("species")
        var species:  List<String>? = null,
        @Expose
        @Ignore
        @SerializedName("films")
        var films:  List<String>? = null,
        @Expose
        @SerializedName("homeworld")
        var homeworld: String? = "",
        @Expose
        @SerializedName("gender")
        var gender: String? = "",
        @Expose
        @SerializedName("birth_year")
        var birth_year: String? = "",
        @Expose
        @SerializedName("eye_color")
        var eye_color: String? = "",
        @Expose
        @SerializedName("skin_color")
        var skin_color: String? = "",
        @Expose
        @SerializedName("hair_color")
        var hair_color: String? = "",
        @Expose
        @SerializedName("mass")
        var mass: String? = "",
        @Expose
        @SerializedName("height")
        var height: String? = "",
        @Expose

        @SerializedName("name")
        var name: String? = ""
)