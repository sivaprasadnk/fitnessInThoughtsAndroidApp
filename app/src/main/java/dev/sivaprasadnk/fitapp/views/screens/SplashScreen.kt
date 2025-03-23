package dev.sivaprasadnk.fitapp.views.screens

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    navController: NavHostController = rememberNavController(),
    blogViewModel: BlogViewModel
) {
    val context = LocalContext.current
    var isConnected by remember { mutableStateOf(checkInternetConnection(context)) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(isConnected) {
        if (isConnected) {
            coroutineScope.launch {
                delay(1000) // Small delay for smoother transition
                blogViewModel.fetchRecentBlogs()
                navController.navigate("home_screen") {
                    popUpTo("splash_screen") { inclusive = true }
                }
            }
        }
    }

    DisposableEffect(context) {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                isConnected = true
            }

            override fun onLost(network: Network) {
                isConnected = false
            }
        }

        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)

        onDispose {
            connectivityManager.unregisterNetworkCallback(networkCallback)
        }
    }

    // UI
    Scaffold(containerColor = colorResource(R.color.bgColor)) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
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

// Function to check initial network state
fun checkInternetConnection(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}
