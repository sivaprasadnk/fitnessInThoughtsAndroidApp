package dev.sivaprasadnk.fitapp.views.screens

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.data.BlogViewModel
import dev.sivaprasadnk.fitapp.views.components.HeightBox
import dev.sivaprasadnk.fitapp.views.components.VersionText

@Composable
fun SplashScreen(
    navController: NavHostController = rememberNavController(),
    blogViewModel: BlogViewModel,
) {
    val context = LocalContext.current
    var isConnected by remember { mutableStateOf(checkInternetConnection(context)) }

    // Automatically update connection status
    LaunchedEffect(Unit) {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: android.net.Network) {
                isConnected = true
//                navigateToHome(blogViewModel, navController)

            }

            override fun onLost(network: android.net.Network) {
                isConnected = false
            }
        }

        connectivityManager.registerDefaultNetworkCallback(networkCallback)

        // Cleanup when composable is removed
//        onDispose {
//            connectivityManager.unregisterNetworkCallback(networkCallback)
//        }
    }

    // Automatically navigate when connected
    LaunchedEffect(isConnected) {
        if (isConnected) {
            navigateToHome(blogViewModel, navController)
        }
    }

    Scaffold(
        containerColor = colorResource(R.color.bgColor)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val configuration = LocalConfiguration.current
            HeightBox((configuration.screenHeightDp * 0.37).toInt())

            Box(
                modifier = Modifier
                    .size(196.dp)
                    .shadow(12.dp, shape = RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.play_store_icon),
                    contentDescription = "logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            VersionText()
            HeightBox(20)

            if (!isConnected) {
                Text("No Internet connection. Waiting for connection...")
            }
        }
    }



}

fun navigateToHome(blogViewModel: BlogViewModel, navController: NavHostController){
    blogViewModel.fetchRecentBlogs()
        navController.navigate("home_screen") {
            popUpTo("splash_screen") { inclusive = true }
        }
}


// Function to check initial network state
fun checkInternetConnection(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}
