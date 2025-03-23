package dev.sivaprasadnk.fitapp.constants

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object Constants{
    const val BASE_URL = "https://fitnessblogbackend-production.up.railway.app/"
    const val QUOTE = "Fitness is not about being better than someone else; \nit's about being better than you used to be."
}

fun checkInternetConnection(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}