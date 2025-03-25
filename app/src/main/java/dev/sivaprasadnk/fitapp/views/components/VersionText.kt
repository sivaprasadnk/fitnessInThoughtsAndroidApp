package dev.sivaprasadnk.fitapp.views.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.core.content.pm.PackageInfoCompat
import dev.sivaprasadnk.fitapp.R

@Composable
fun VersionText() {
    val context = LocalContext.current;
    val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
    val versionName = packageInfo.versionName
    val versionCode = PackageInfoCompat.getLongVersionCode(packageInfo)

    Text(
        "v$versionName+$versionCode",
        textAlign = TextAlign.Center,
        fontFamily = FontFamily(Font(R.font.lora_regular))
    )
}