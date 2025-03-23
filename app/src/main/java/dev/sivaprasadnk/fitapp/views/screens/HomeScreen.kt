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
import dev.sivaprasadnk.fitapp.data.BlogViewModel

import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.views.components.AppBar
import dev.sivaprasadnk.fitapp.views.components.CoverImage
import dev.sivaprasadnk.fitapp.views.components.FeaturedPost
import dev.sivaprasadnk.fitapp.views.components.HeightBox
import dev.sivaprasadnk.fitapp.views.components.QuoteSection
import dev.sivaprasadnk.fitapp.views.components.RecentPosts

@Composable
fun HomeScreen(blogViewModel: BlogViewModel) {
    val blogs by blogViewModel.blogs
    Scaffold(
        containerColor = colorResource(R.color.bgColor),
        topBar = {
            AppBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            CoverImage()
            blogs.find { it.is_featured }?.let { FeaturedPost(it) }
            HeightBox(50)
            RecentPosts(blogs.take(3))
            HeightBox(20)
            QuoteSection()
            HeightBox(20)


        }
    }
}