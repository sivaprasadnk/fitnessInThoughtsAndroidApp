package dev.sivaprasadnk.fitapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.sivaprasadnk.fitapp.components.AppBar
import dev.sivaprasadnk.fitapp.components.CoverImage
import dev.sivaprasadnk.fitapp.components.FeaturedPost
import dev.sivaprasadnk.fitapp.components.HeightBox
import dev.sivaprasadnk.fitapp.components.SectionTitle

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        containerColor = colorResource(R.color.bgColor),
        topBar = {
            AppBar()
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .verticalScroll(rememberScrollState())) {
            CoverImage()
            FeaturedPost()
            HeightBox(50)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = Color.White)
            ) {
                Column {
                    SectionTitle("R E C E N T")
                    Image(
                        painter = painterResource(R.drawable.featured),
                        contentDescription = "featured",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .padding(start = 8.dp, end = 8.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    HeightBox(20)

                }
            }
            HeightBox(20)

        }
    }
}