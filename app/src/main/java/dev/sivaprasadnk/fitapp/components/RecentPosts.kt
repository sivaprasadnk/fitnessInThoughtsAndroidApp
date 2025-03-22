package dev.sivaprasadnk.fitapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.sivaprasadnk.fitapp.BlogViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RecentPosts(blogViewModel: BlogViewModel = viewModel()) {
    val blogs by blogViewModel.blogs

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
