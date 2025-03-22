package dev.sivaprasadnk.fitapp.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import dev.sivaprasadnk.fitapp.BlogViewModel
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.components.VersionText
import dev.sivaprasadnk.fitapp.constants.ApiConstants.BASE_URL
import dev.sivaprasadnk.fitapp.data.Blog
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

@Composable
fun SplashScreen(navController: NavController, blogViewModel: BlogViewModel = viewModel()) {
    val blogs by blogViewModel.blogs

    LaunchedEffect(blogs) {
        if(blogs.isNotEmpty()){
            delay(2000)
            navController.navigate("home_screen") {
                popUpTo("splash_screen") { inclusive = true }
            }
        }


    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.bgColor)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(128.dp)
                    .shadow(12.dp, shape = RoundedCornerShape(8.dp)) // Adding shadow
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
        }

    }
}

suspend fun fetchApi(): Response<List<Blog>> {
    return try {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(ApiService::class.java)
        apiService.getBlogs()

    } catch (e: Exception) {
        Response.error(500, "Error".toResponseBody(null))
    }

}

interface ApiService {
    @GET("blogs")
    suspend fun getBlogs(): Response<List<Blog>>
}