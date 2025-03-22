package dev.sivaprasadnk.fitapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.sivaprasadnk.fitapp.R

@Composable
fun CoverImage() {
    Box(modifier = Modifier.padding(all = 16.dp)) {
        Image(
            painter = painterResource(R.drawable.cover),
            contentDescription = "cover",
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            "Welcome to ${stringResource(R.string.app_title)}",
            color = Color.White,
            fontWeight = FontWeight.W600,
            fontFamily = FontFamily(Font(R.font.playfair_display)),
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 16.dp, bottom = 16.dp)
        )
    }
}