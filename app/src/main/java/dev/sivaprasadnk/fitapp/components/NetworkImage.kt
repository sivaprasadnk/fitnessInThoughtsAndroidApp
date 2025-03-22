package dev.sivaprasadnk.fitapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun NetworkImage(imageUrl: String){
    Box(
        modifier = Modifier.fillMaxWidth()
            .height(250.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build()
        )

        Image(
            painter = painter,
            contentDescription = "featured",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        if (painter.state is coil.compose.AsyncImagePainter.State.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}