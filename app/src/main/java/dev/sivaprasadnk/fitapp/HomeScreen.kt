package dev.sivaprasadnk.fitapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.sivaprasadnk.fitapp.components.AppBar
import dev.sivaprasadnk.fitapp.components.CoverImage

@OptIn(ExperimentalMaterial3Api::class)
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = Color.White)
            ) {
                Column {
                    Text(
                        "F E A T U R E D",
                        modifier = Modifier.padding(all = 8.dp),
                        fontSize = 24.sp
                    )
                    Text(
                        "P O S T",
                        modifier = Modifier.padding(start = 8.dp),
                        fontSize = 24.sp
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Box(
                        modifier = Modifier
                            .width(50.dp)  // Width of 50dp
                            .height(5.dp)  // Height of 5dp
                            .padding(start = 8.dp)
                            .background(Color.Gray) // Change color as needed
                    )
                    Spacer(modifier = Modifier.height(50.dp))

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
                    Spacer(modifier = Modifier.height(50.dp))

                }
            }
            Spacer(modifier = Modifier.height(50.dp))

        }
    }
}