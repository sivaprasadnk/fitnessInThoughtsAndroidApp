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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
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
    val blogs by blogViewModel.blogs
    val isLoading by blogViewModel.loading
    var isCompleted = blogViewModel.completed.value
    val context = LocalContext.current
    var isConnected by remember { mutableStateOf(checkInternetConnection(context)) }

    LaunchedEffect(isConnected, blogs, isLoading) {
        if (isConnected) {
            if (isCompleted) {
                navController.navigate("home_screen") {
                    popUpTo("splash_screen") { inclusive = true }
                }

            }
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
                    .shadow(12.dp, shape = RoundedCornerShape(16.dp)) // Adding shadow
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White) // Optional: Better visibility
            ) {
                Image(
                    painter = painterResource(id = R.drawable.play_store_icon),
                    contentDescription = "logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            VersionText()
            HeightBox(20)
            if (!isCompleted)
                Button(onClick = {
                    isConnected = checkInternetConnection(context)
                    if (isConnected) {
                        blogViewModel.fetchRecentBlogs()
                        isCompleted = blogViewModel.completed.value
                        if (isCompleted) {
                            navController.navigate("home_screen") {
                                popUpTo("splash_screen") { inclusive = true }
                            }

                        }
                    } else {
                        showToast(context, "No Internet Connection")
                    }
                }) {
                    if (isLoading)
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier.size(24.dp)
                        ) else {
                        Text("Continue")
                    }
                }
        }

    }

}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun checkInternetConnection(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}