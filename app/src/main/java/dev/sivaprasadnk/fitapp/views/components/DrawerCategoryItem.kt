package dev.sivaprasadnk.fitapp.views.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.toLowerCase
import androidx.navigation.NavController
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.constants.checkInternetConnection
import dev.sivaprasadnk.fitapp.data.BlogViewModel

@Composable
fun CategoryItem(navController: NavController, title:String){
    val context = LocalContext.current
    Text(
        title,
        fontFamily = FontFamily(Font(R.font.lora_regular)),
        modifier = Modifier.clickable {
            if (checkInternetConnection(context)) {
                navController.navigate("all_posts_screen/${title.lowercase()}", )

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
}