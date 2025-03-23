package dev.sivaprasadnk.fitapp.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
fun FeaturedPost(blog: Blog){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color.White)
    ) {
        Column {
            SectionTitle("F E A T U R E D")
            Box(
                modifier = Modifier.padding(8.dp)
            ) {
                BlogItem(blog)
            }
            HeightBox(20)
        }
    }
}