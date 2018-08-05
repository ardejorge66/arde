package br.com.levisaturnino.starwars.domain

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
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
):Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.createStringArrayList(),
                parcel.createStringArrayList(),
                parcel.createStringArrayList(),
                parcel.createStringArrayList(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeValue(id)
                parcel.writeString(url)
                parcel.writeString(edited)
                parcel.writeString(created)
                parcel.writeStringList(starships)
                parcel.writeStringList(vehicles)
                parcel.writeStringList(species)
                parcel.writeStringList(films)
                parcel.writeString(homeworld)
                parcel.writeString(gender)
                parcel.writeString(birth_year)
                parcel.writeString(eye_color)
                parcel.writeString(skin_color)
                parcel.writeString(hair_color)
                parcel.writeString(mass)
                parcel.writeString(height)
                parcel.writeString(name)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<People> {
                override fun createFromParcel(parcel: Parcel): People {
                        return People(parcel)
                }

                override fun newArray(size: Int): Array<People?> {
                        return arrayOfNulls(size)
                }
        }
}