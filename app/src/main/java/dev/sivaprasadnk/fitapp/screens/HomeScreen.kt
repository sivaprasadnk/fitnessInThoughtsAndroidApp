package dev.sivaprasadnk.fitapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.components.AppBar
import dev.sivaprasadnk.fitapp.components.CoverImage
import dev.sivaprasadnk.fitapp.components.FeaturedPost
import dev.sivaprasadnk.fitapp.components.HeightBox
import dev.sivaprasadnk.fitapp.components.RecentPosts

@Composable
fun HomeScreen(
) {
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
            FeaturedPost()
            HeightBox(50)
            RecentPosts()
            HeightBox(20)

        }
    }
}