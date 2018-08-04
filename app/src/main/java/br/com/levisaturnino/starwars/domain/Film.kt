package br.com.levisaturnino.starwars.domain

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Film(
        @Expose
        @SerializedName("title")
        val title: String,

        @Expose
        @SerializedName("opening_crawl")
        val opening_crawl: String,
        @Expose
        @SerializedName("director")
        val director: String,
        @Expose
        @SerializedName("producer")
        val producer: String,
        @Expose
        @SerializedName("release_date")
        val release_date: String,
        @Expose
        @SerializedName("characters")
        var characters: List<String>,
        @Expose
        @SerializedName("planets")
        var planets: List<String>,
        @Expose
        @SerializedName("starships")
        var starships: List<String>,
        @Expose
        @SerializedName("vehicles")
        var vehicles: List<String>,
        @Expose
        @SerializedName("species")
        var species: List<String>,
        @Expose
        @SerializedName("created")
        val created: String,
        @Expose
        @SerializedName("edited")
        val edited: String,
        @Expose
        @SerializedName("url")
        val url: String):Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.createStringArrayList(),
                parcel.createStringArrayList(),
                parcel.createStringArrayList(),
                parcel.createStringArrayList(),
                parcel.createStringArrayList(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(title)
                parcel.writeString(opening_crawl)
                parcel.writeString(director)
                parcel.writeString(producer)
                parcel.writeString(release_date)
                parcel.writeStringList(characters)
                parcel.writeStringList(planets)
                parcel.writeStringList(starships)
                parcel.writeStringList(vehicles)
                parcel.writeStringList(species)
                parcel.writeString(created)
                parcel.writeString(edited)
                parcel.writeString(url)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Film> {
                override fun createFromParcel(parcel: Parcel): Film {
                        return Film(parcel)
                }

                override fun newArray(size: Int): Array<Film?> {
                        return arrayOfNulls(size)
                }
        }
}