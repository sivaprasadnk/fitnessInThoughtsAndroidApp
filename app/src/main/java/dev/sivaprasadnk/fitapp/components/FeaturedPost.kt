package dev.sivaprasadnk.fitapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.sivaprasadnk.fitapp.R

@Composable
fun FeaturedPost(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color.White)
    ) {
        Column {
            SectionTitle("F E A T U R E D")
            Image(
                painter = painterResource(R.drawable.featured),
                contentDescription = "featured",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(start = 8.dp, end = 8.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            HeightBox(20)
        }
    }
}