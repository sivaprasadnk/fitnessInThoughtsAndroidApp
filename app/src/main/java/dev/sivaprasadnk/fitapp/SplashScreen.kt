package dev.sivaprasadnk.fitapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("home_screen"){
            popUpTo("home_screen") { inclusive= true }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize().background(color = colorResource(R.color.bgColor)),
        contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.play_store_icon),
                contentDescription = "logo",
                modifier = Modifier.size(512.dp))
    }
}