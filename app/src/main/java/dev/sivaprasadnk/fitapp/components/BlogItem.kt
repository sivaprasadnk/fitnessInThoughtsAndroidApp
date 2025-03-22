package dev.sivaprasadnk.fitapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.colintheshots.twain.MarkdownText
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.data.Blog

@Composable
fun BlogItem(blog: Blog){
    Column(
    ) {
//        Image(
//            painter = rememberAsyncImagePainter(blog.imageNetworkPath),
//            contentDescription = "featured",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(250.dp)
//                .clip(RoundedCornerShape(8.dp))
//        )
        NetworkImage(blog.imageNetworkPath)
        HeightBox(16)
        Text(blog.dateString, fontSize = 12.sp, color = Color.Gray)
        HeightBox(10)
        MarkdownText(
            markdown = blog.title,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.lora_regular))
            ),
            modifier = Modifier.fillMaxWidth()
        )
        HeightBox(10)
        MarkdownText(
            markdown = blog.subTitle,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.lora_regular))
            ),
            modifier = Modifier.fillMaxWidth()
        )
        HeightBox(10)
        ReadMoreButton()
        HeightBox(16)

    }
}