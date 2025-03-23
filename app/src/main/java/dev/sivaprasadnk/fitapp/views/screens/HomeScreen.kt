package dev.sivaprasadnk.fitapp.views.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import dev.sivaprasadnk.fitapp.data.BlogViewModel

import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.views.components.AppBar
import dev.sivaprasadnk.fitapp.views.components.CoverImage
import dev.sivaprasadnk.fitapp.views.components.FeaturedPost
import dev.sivaprasadnk.fitapp.views.components.Footer
import dev.sivaprasadnk.fitapp.views.components.HeightBox
import dev.sivaprasadnk.fitapp.views.components.QuoteSection
import dev.sivaprasadnk.fitapp.views.components.RecentPosts

@Composable
fun HomeScreen(blogViewModel: BlogViewModel, navController: NavHostController) {
    val blogs by blogViewModel.recentBlogs
    Scaffold(
        containerColor = colorResource(R.color.bgColor),
        topBar = {
            AppBar(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            CoverImage()
            blogs.find { it.is_featured }?.let { FeaturedPost(it, navController) }
            HeightBox(50)
            RecentPosts(blogs, navController)
            HeightBox(20)
            QuoteSection()
            HeightBox(30)
            Footer()
            HeightBox(10)
        }
    }
}