package dev.sivaprasadnk.fitapp.views.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.constants.checkInternetConnection
import dev.sivaprasadnk.fitapp.data.BlogViewModel

@Composable
fun ShowAll(navHostController: NavHostController, blogViewModel: BlogViewModel) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                if (checkInternetConnection(context)) {
                    blogViewModel.updateCategory("all")

                    navHostController.navigate("all_posts_screen")

                } else {
                    Toast
                        .makeText(
                            context,
                            "No Internet connection. Please try again",
                            Toast.LENGTH_LONG
                        )
                        .show()
                }
            },
        horizontalArrangement = Arrangement.Absolute.Center
    ) {
        Text(
            stringResource(R.string.show_all),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.lora_regular))
        )
        WidthBox(10)
        Icon(
            Icons.AutoMirrored.Rounded.ArrowForward,
            contentDescription = "arrow",
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.CenterVertically)
        )
    }
}