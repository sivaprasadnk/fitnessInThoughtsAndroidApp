package dev.sivaprasadnk.fitapp.data

data class Blog(
    val id: Int,
    val title: String,
    val dateString: String,
    val subTitle: String,
    val content: String,
    val imageAssetPath: String,
    val imageNetworkPath: String,
    val isActive: Boolean,
    val isFeatured: Boolean,
    val cacheKey: String
)
