package dev.sivaprasadnk.fitapp.views.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.data.Blog
import dev.sivaprasadnk.fitapp.data.BlogViewModel
import dev.sivaprasadnk.fitapp.views.components.AppBar

@Composable
fun DetailsScreen(id: Int, blogViewModel: BlogViewModel) {
    LaunchedEffect(id) {
        blogViewModel.fetchBlogDetails(id)
    }

    val blog by blogViewModel.blog

    Scaffold(
        containerColor = colorResource(R.color.bgColor),
        topBar = {
            AppBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            if (blog?.id === blog?.id)
                Text(blog?.title ?: "title")

        }
    }
}