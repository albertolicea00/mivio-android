package com.albertolicea00.mivio.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SettingsRemote
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.albertolicea00.mivio.ui.home.HomeScreen
import com.albertolicea00.mivio.ui.detail.DetailScreen
import com.albertolicea00.mivio.ui.player.PlayerScreen
import com.albertolicea00.mivio.ui.source.SourceScreen
import com.albertolicea00.mivio.ui.remote.RemoteScreen
import com.albertolicea00.mivio.ui.search.SearchScreen
import com.albertolicea00.mivio.ui.settings.SettingsScreen

@Composable
fun MivioNavGraph(navController: NavHostController = rememberNavController()) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Define items to show in bottom bar
    val bottomNavItems = listOf(
        Triple("remote", "Remote", Icons.Default.SettingsRemote),
        Triple("sources", "Files", Icons.Default.Folder),
        Triple("home", "Home", Icons.Default.Home),
        Triple("search", "Search", Icons.Default.Search),
        Triple("settings", "Settings", Icons.Default.Settings)
    )

    // Show bottom bar only on top-level destinations
    val showBottomBar = bottomNavItems.any { it.first == currentRoute }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = Color(0xFF191A23), // Match search bar background
                    contentColor = Color.White
                ) {
                    bottomNavItems.forEach { (route, title, icon) ->
                        NavigationBarItem(
                            icon = { Icon(icon, contentDescription = title) },
                            label = { Text(title) },
                            selected = currentRoute == route,
                            onClick = {
                                navController.navigate(route) {
                                    popUpTo("home") {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color(0xFFF14911), // Brand Primary
                                selectedTextColor = Color(0xFFF14911),
                                unselectedIconColor = Color(0xFF7E8494), // Muted Gray
                                unselectedTextColor = Color(0xFF7E8494),
                                indicatorColor = Color.Transparent
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("remote") {
                RemoteScreen()
            }
            composable("sources") {
                SourceScreen()
            }
            composable("home") {
                HomeScreen(onNavigateToSources = {
                    navController.navigate("sources")
                })
            }
            composable("search") {
                SearchScreen()
            }
            composable("settings") {
                SettingsScreen()
            }
            composable("detail/{mediaId}") { backStackEntry ->
                val mediaId = backStackEntry.arguments?.getString("mediaId") ?: ""
                DetailScreen(mediaId = mediaId, onPlayClicked = {
                    navController.navigate("player/$mediaId")
                })
            }
            composable("player/{mediaId}") { backStackEntry ->
                val mediaId = backStackEntry.arguments?.getString("mediaId") ?: ""
                PlayerScreen(videoUrl = "https://www.w3schools.com/html/mov_bbb.mp4")
            }
        }
    }
}
