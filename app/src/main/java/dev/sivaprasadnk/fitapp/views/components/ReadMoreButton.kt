package dev.sivaprasadnk.fitapp.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.sivaprasadnk.fitapp.R

@Composable
fun ReadMoreButton() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            stringResource(R.string.read_more),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.lora_regular))
        )
        WidthBox(10)
        Icon(
            Icons.AutoMirrored.Rounded.ArrowForward,
            contentDescription = "arrow",
            modifier = Modifier.size(16.dp).align(Alignment.CenterVertically)
        )
    }
}