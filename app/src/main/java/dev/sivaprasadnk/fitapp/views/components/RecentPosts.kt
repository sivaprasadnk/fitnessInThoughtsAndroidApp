package dev.sivaprasadnk.fitapp.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.sivaprasadnk.fitapp.data.Blog

@Composable
fun RecentPosts(blogs: List<Blog>) {

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
                    .padding(16.dp)
            ) {
                blogs.take(3).forEach { blog ->
                    BlogItem(blog) // ✅ Replaces LazyColumn with Column
                }
            }

        HeightBox(20)
    }
}
