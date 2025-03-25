package dev.sivaprasadnk.fitapp.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.data.BlogViewModel
import dev.sivaprasadnk.fitapp.views.components.AppBar
import dev.sivaprasadnk.fitapp.views.components.BlogItem
import dev.sivaprasadnk.fitapp.views.components.HeightBox
import dev.sivaprasadnk.fitapp.views.components.SectionTitle

@Composable
fun AllPostsScreen(blogViewModel: BlogViewModel, navController: NavHostController) {

    LaunchedEffect(Unit) {
        blogViewModel.fetchAllBlogs()
    }

    val blogs by blogViewModel.allBlogs

    Scaffold(
        containerColor = colorResource(R.color.bgColor),
        topBar = {
            AppBar(navController, showBackIcon = true, onMenuClick = {})
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .padding(all = 16.dp)

        ) {

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .background(color = Color.White)
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
            ) {
                SectionTitle("A L L")
                HeightBox(20)
                if(blogs.isEmpty())
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Absolute.Center

                    ) {
                        CircularProgressIndicator()
                    }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp)
                ) {
                    blogs.forEach { blog ->
                        BlogItem(blog, navController) // ✅ Replaces LazyColumn with Column
                    }
                }

                HeightBox(20)

            }
        }
    }
}