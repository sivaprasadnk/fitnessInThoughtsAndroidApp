package dev.sivaprasadnk.fitapp.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.constants.Constants.QUOTE

@Composable
fun QuoteSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeightBox(44)
        Image(
            painter = painterResource(R.drawable.quote),
            contentDescription = "",
            modifier = Modifier.size(40.dp)
        )
        HeightBox(46)
        Text(
            QUOTE,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.lora_regular)),
            modifier = Modifier.padding(all = 16.dp)
        )
    }
}