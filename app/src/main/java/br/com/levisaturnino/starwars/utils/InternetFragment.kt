package br.com.levisaturnino.starwars.utils


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import br.com.levisaturnino.starwars.utils.Utils.isNetworkAvailable


@Suppress("DEPRECATION")
abstract class InternetFragment : Fragment() {

    private var mReceiver: ConexaoReceiver? = null

     override fun onResume() {
        super.onResume()
        mReceiver = ConexaoReceiver()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
         activity?.registerReceiver(mReceiver, filter)
    }

     override fun onPause() {
        super.onPause()
        activity?.unregisterReceiver(mReceiver)
    }

    abstract fun iniciarDownload()

    internal inner class ConexaoReceiver : BroadcastReceiver() {

        var mPrimeiraVez = true

        override fun onReceive(context: Context, intent: Intent) {

            if (mPrimeiraVez) {
                mPrimeiraVez = false
                return
            }

            if (ConnectivityManager.CONNECTIVITY_ACTION == intent.action) {
                if (isNetworkAvailable(context)) {
                    iniciarDownload()
                }
            }
        }
    }


    inner class NetworkStateReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Log.d("app", "Network connectivity change")
            if (intent.extras != null) {
                val ni = intent.extras!!.get(ConnectivityManager.EXTRA_NETWORK_INFO) as NetworkInfo
                if (ni.state == NetworkInfo.State.CONNECTED) {
                    Log.i("app", "Network " + ni.typeName + " connected")
                } else if (intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, java.lang.Boolean.FALSE)) {
                    Log.d("app", "There's no network connectivity")
                }
            }
        }
    }
}

