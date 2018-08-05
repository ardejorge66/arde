package br.com.levisaturnino.starwars.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.widget.Toast
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
        val connectivityManager = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            assert(connectivityManager != null)
            val networks = connectivityManager.allNetworks
            var networkInfo: NetworkInfo
            for (mNetwork in networks) {
                networkInfo = connectivityManager.getNetworkInfo(mNetwork)
                if (networkInfo.state == NetworkInfo.State.CONNECTED) {
                    return true
                }
            }
        } else {
            if (connectivityManager != null) {

                val info = connectivityManager.allNetworkInfo
                if (info != null) {
                    for (anInfo in info) {
                        if (anInfo.state == NetworkInfo.State.CONNECTED) {
                            // Log.d("Network","NETWORKNAME: " + anInfo.getTypeName());
                            return true
                        }
                    }
                }
            }
        }
        Toast.makeText(mContext, mContext.getString(R.string.erro_conexao_indisponivel), Toast.LENGTH_SHORT).show()
        return false
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