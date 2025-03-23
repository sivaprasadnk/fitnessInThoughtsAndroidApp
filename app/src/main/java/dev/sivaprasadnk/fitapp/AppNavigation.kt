package dev.sivaprasadnk.fitapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.sivaprasadnk.fitapp.data.BlogViewModel
import dev.sivaprasadnk.fitapp.views.screens.HomeScreen
import dev.sivaprasadnk.fitapp.views.screens.SplashScreen

@Composable
fun AppNavigation(
    blogViewModel: BlogViewModel = viewModel<BlogViewModel>()
) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController, blogViewModel)
        }
        composable("home_screen") {
            HomeScreen(blogViewModel)
        }
    }


}