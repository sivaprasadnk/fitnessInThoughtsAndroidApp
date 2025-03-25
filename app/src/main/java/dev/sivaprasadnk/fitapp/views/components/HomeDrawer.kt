package dev.sivaprasadnk.fitapp.views.components

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.constants.Constants.PLAYSTORE_URL
import dev.sivaprasadnk.fitapp.constants.checkInternetConnection

@Composable
fun HomeDrawer(navController: NavController) {
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val context = LocalContext.current
    Box {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .width((width * 0.6).toInt().dp)
                .background(color = Color.White)
        ) {
            HeightBox(100)
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .shadow(12.dp, shape = RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.play_store_icon),
                    contentDescription = "logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            HeightBox(50)
            Text("Home", fontFamily = FontFamily(Font(R.font.lora_regular)))
            HorizontalDivider(
                modifier = Modifier.padding(all = 16.dp)
            )
            Text(
                "All Posts",
                fontFamily = FontFamily(Font(R.font.lora_regular)),
                modifier = Modifier.clickable {
                    if (checkInternetConnection(context)) {
                        navController.navigate("all_posts_screen")

                    } else {
                        Toast
                            .makeText(
                                context,
                                "No Internet connection. Please try again",
                                Toast.LENGTH_LONG
                            )
                            .show()
                    }
                })
            HorizontalDivider(
                modifier = Modifier.padding(all = 16.dp)
            )
            HeightBox(100)
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (checkInternetConnection(context)) {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(PLAYSTORE_URL))
                            context.startActivity(intent)

                        } else {
                            Toast
                                .makeText(
                                    context,
                                    "No Internet connection. Please try again",
                                    Toast.LENGTH_LONG
                                )
                                .show()
                        }
                    }
            ) {
                Text(
                    "Check for update",
                    fontFamily = FontFamily(Font(R.font.lora_regular))
                )
                Icon(Icons.Default.Refresh, contentDescription = "refresh")
            }
            HorizontalDivider(
                modifier = Modifier.padding(all = 16.dp)
            )
            VersionText()
        }
    }
}