package dev.sivaprasadnk.fitapp.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.sivaprasadnk.fitapp.R

@Composable
fun SectionTitle(title: String, subTitle: String = "P O S T S"){
    Column {
        Text(
            title,
            fontFamily = FontFamily(Font(R.font.playfair_display)),
            modifier = Modifier.padding(all = 8.dp),
            fontSize = 24.sp
        )
        Text(
            subTitle,
            fontFamily = FontFamily(Font(R.font.playfair_display)),
            modifier = Modifier.padding(start = 8.dp),
            fontSize = 24.sp
        )
        HeightBox(24)
        Box(
            modifier = Modifier
                .width(50.dp)  // Width of 50dp
                .height(5.dp)  // Height of 5dp
                .padding(start = 8.dp)
                .background(colorResource(R.color.orange)) // Change color as needed
        )
        HeightBox(30)
    }
}