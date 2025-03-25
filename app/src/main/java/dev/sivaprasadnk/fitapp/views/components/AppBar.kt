package dev.sivaprasadnk.fitapp.views.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import dev.sivaprasadnk.fitapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(navController: NavController, showBackIcon: Boolean = false, onMenuClick: ()-> Unit){
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        ),
        navigationIcon = {
            if(showBackIcon){
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "back")
                }
            }else{
                IconButton(onClick = {
                    onMenuClick()
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
                }
            }
        },
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    stringResource(R.string.app_title),
                    textAlign = if (showBackIcon) TextAlign.Start else TextAlign.Start,
                    fontFamily = FontFamily(Font(R.font.lora_bold)),
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    )
}