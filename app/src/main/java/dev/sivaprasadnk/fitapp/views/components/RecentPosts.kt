package dev.sivaprasadnk.fitapp.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.sivaprasadnk.fitapp.data.Blog

@Composable
fun RecentPosts(blogs: List<Blog>, navController: NavHostController) {

    Column( // ✅ Use Column with a constrained height
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
    ) {
        SectionTitle("R E C E N T")
        if (blogs.isNotEmpty())
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp)
            ) {
                blogs.take(3).forEach { blog ->
                    BlogItem(blog, navController) // ✅ Replaces LazyColumn with Column
                }
            }
        HorizontalDivider(
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        HeightBox(10)
        ShowAll()
        HeightBox(10)
    }
}
