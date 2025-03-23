package dev.sivaprasadnk.fitapp.views.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.data.BlogViewModel
import dev.sivaprasadnk.fitapp.views.components.*

@Composable
fun HomeScreen(blogViewModel: BlogViewModel, navController: NavHostController) {
    val blogs by blogViewModel.recentBlogs
    val isCompleted by blogViewModel.completed
    val isLoading by blogViewModel.loading

    Scaffold(
        containerColor = colorResource(R.color.bgColor),
        topBar = { AppBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CoverImage()

            // Show loading indicator if data is still loading
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.padding(top = 50.dp)
                )
            } else {
                // Show Featured Post if available
                blogs.find { it.is_featured }?.let {
                    FeaturedPost(it, navController)
                }

                HeightBox(50)

                // Show recent posts only if data is loaded
                if (isCompleted) {
                    RecentPosts(blogs, navController)
                    HeightBox(20)
                    QuoteSection()
                    HeightBox(30)
                    Footer()
                    HeightBox(10)
                }
            }
        }
    }
}
