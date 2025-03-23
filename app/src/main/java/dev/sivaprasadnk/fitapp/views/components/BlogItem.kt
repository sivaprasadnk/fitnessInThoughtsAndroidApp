package dev.sivaprasadnk.fitapp.views.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.colintheshots.twain.MarkdownText
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.data.Blog

@Composable
fun BlogItem(blog: Blog, navController: NavHostController= rememberNavController()) {
    Column(
        modifier = Modifier.clickable {
            Log.d("fetchBlogDetails @1", "tapped");

            navController.navigate("details_screen/${blog.id}")
        }
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
        if (blog.image_network_path != null)
            NetworkImage(blog.image_network_path)
        HeightBox(16)
        if (blog.date_string != null)

            Text(blog.date_string, fontSize = 12.sp, color = Color.Gray)
        HeightBox(10)
        if (blog.title != null)
            MarkdownText(
                markdown = blog.title,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.lora_regular))
                ),
                modifier = Modifier.fillMaxWidth()
            )
        HeightBox(10)
        if (blog.sub_title != null)

            MarkdownText(
                markdown = blog.sub_title,
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