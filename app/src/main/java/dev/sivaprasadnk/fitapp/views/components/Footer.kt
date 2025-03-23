package dev.sivaprasadnk.fitapp.views.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.sivaprasadnk.fitapp.R
import java.time.Year

@Composable
fun Footer() {
    val year = Year.now().value
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            Text("© $year", fontSize = 13.sp, fontFamily = FontFamily(Font(R.font.lora_regular)))
            WidthBox(5)
            Text(
                "www.sivaprasadnk.dev",
                color = Color.Blue,
                fontSize = 15.sp,
                fontWeight = FontWeight.W400,
                fontFamily = FontFamily(Font(R.font.lora_regular)),
                modifier = Modifier.clickable {
                    val url = "https://www.sivaprasadnk.dev"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                })
        }
        Text(
            "Made with ❤️ in Android", fontSize = 15.sp,
            fontWeight = FontWeight.W400,
            fontFamily = FontFamily(Font(R.font.lora_regular)),
        )
    }
}