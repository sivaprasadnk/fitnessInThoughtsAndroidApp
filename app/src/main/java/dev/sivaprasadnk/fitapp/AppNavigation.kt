package dev.sivaprasadnk.fitapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.sivaprasadnk.fitapp.data.BlogViewModel
import dev.sivaprasadnk.fitapp.views.screens.AllPostsScreen
import dev.sivaprasadnk.fitapp.views.screens.DetailsScreen
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
            HomeScreen(navController)
        }
        composable("details_screen/{id}") { backStackEntry ->
            val blogId = backStackEntry.arguments?.getString("id")?.toInt() ?: -1
            DetailsScreen(blogId, blogViewModel, navController )
        }
        composable("all_posts_screen/{category}") {backStackEntry ->
            val category  = backStackEntry.arguments?.getString("category") ?: "all"
            AllPostsScreen(blogViewModel, navController, category )
        }
    }


}