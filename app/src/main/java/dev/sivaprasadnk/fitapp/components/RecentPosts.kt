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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.sivaprasadnk.fitapp.data.blogs

@Composable
fun RecentPosts() {
    Column( // ✅ Use Column with a constrained height
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
    ) {
        SectionTitle("R E C E N T")

        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            blogs.forEach { blog ->
                BlogItem(blog) // ✅ Replaces LazyColumn with Column
            }
        }

        HeightBox(20)
    }
}
