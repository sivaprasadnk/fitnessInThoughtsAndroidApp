package dev.sivaprasadnk.fitapp.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.colintheshots.twain.MarkdownText
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.data.Blog
import dev.sivaprasadnk.fitapp.data.BlogViewModel
import dev.sivaprasadnk.fitapp.views.components.AppBar
import dev.sivaprasadnk.fitapp.views.components.HeightBox
import dev.sivaprasadnk.fitapp.views.components.NetworkImage

@Composable
fun DetailsScreen(id: Int, blogViewModel: BlogViewModel, navController: NavController) {
    LaunchedEffect(id) {
        blogViewModel.fetchBlogDetails(id)
    }

    val blog by blogViewModel.blog
    val loading by blogViewModel.detailsLoading

    Scaffold(
        containerColor = colorResource(R.color.bgColor),
        topBar = {
            AppBar(navController, showBackIcon = true)
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
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                HeightBox(20)
                if (blog === null)
                    Column {
                        HeightBox(50)
                        CircularProgressIndicator()
                    }
                blog?.date_string?.let { Text(it) }
                HeightBox(16)
                blog?.title?.let {
                    MarkdownText(
                        markdown = it,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.lora_regular))
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                HeightBox(16)
                blog?.image_network_path?.let {
                    NetworkImage(it)
                }
                HeightBox(16)
                blog?.sub_title?.let {
                    MarkdownText(
                        markdown = it,
                    )
                }
                blog?.content?.let {
                    MarkdownText(
                        markdown = it,
                    )
                }
                HeightBox(20)

            }
        }
    }
}