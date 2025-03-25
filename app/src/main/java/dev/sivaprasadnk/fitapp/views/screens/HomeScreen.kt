package dev.sivaprasadnk.fitapp.views.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import dev.sivaprasadnk.fitapp.R
import dev.sivaprasadnk.fitapp.data.BlogViewModel
import dev.sivaprasadnk.fitapp.views.components.*
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController, blogViewModel: BlogViewModel = viewModel()) {
    val blogs by blogViewModel.recentBlogs
    val isCompleted by blogViewModel.completed
    val isLoading by blogViewModel.loading
    val error by blogViewModel.error
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            HomeDrawer(navController)
        },
        drawerState = drawerState,
    ) {
        Scaffold(
            containerColor = colorResource(R.color.bgColor),
            topBar = {
                AppBar(navController, onMenuClick = {
                    scope.launch {
                        drawerState.open()
                    }
                })
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CoverImage()
                if (error.isNotEmpty())
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 8.dp),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(error)
                    }

                // Show loading indicator if data is still loading
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.padding(top = 50.dp)
                    )
                } else {
                    // Show Featured Post if available
                    blogs.find { it.is_featured }?.let {
                        FeaturedPost(it, navController)
                    }

                    HeightBox(50)

                    // Show recent posts only if data is loaded
                    if (isCompleted) {
                        RecentPosts(blogs, navController)
                        HeightBox(20)
                        QuoteSection()
                        HeightBox(30)
                        Footer()
                        HeightBox(10)
                    }
                }
            }
        }
    }
}
