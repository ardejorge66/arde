package br.com.levisaturnino.starwars.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import br.com.levisaturnino.starwars.R
import com.afollestad.materialdialogs.MaterialDialog

object Utils{

    fun getImage( url : String):String{

        return "https://starwars-visualguide.com/assets/img/"+ spliString(url) +".jpg"
    }

    fun getImagePeople( url : String):String{

        return "https://starwars-visualguide.com/assets/img/"+ spliPeopleString(url) +".jpg"
    }

    fun lastString(s: String): String {
        var i = s.length
        while (i > 0 && Character.isDigit(s[i - 1])) {
            i--
        }
        return s.substring(i)
    }

    fun spliString(s: String): String {

        val separated = s.split("/")
        return separated[separated.size - 3]+"/"+separated[separated.size- 2]
    }

    fun spliPeopleString(s: String): String {

        val separated = s.split("/")
        return "characters/"+separated[separated.size- 2]
    }

    fun isNetworkAvailable(mContext: Context): Boolean {
        val connectivityManager = mContext.getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false

    }

    fun getMessage(context: Context) {
        val builder = MaterialDialog.Builder(context)
                .title(R.string.title)
                .content(R.string.content)
                .positiveText(R.string.ok)

        val dialog = builder.build()
        dialog.show()
    }
}