package dev.sivaprasadnk.fitapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.sivaprasadnk.fitapp.screens.HomeScreen
import dev.sivaprasadnk.fitapp.screens.SplashScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier){
    val navController  = rememberNavController()

    NavHost(navController, startDestination = "splash_screen"){
        composable("splash_screen") {
            SplashScreen(navController)
        }
        composable("home_screen") {
            HomeScreen()
        }
    }


}