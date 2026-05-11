package com.albertolicea00.mivio.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.albertolicea00.mivio.ui.home.HomeScreen
import com.albertolicea00.mivio.ui.detail.DetailScreen
import com.albertolicea00.mivio.ui.player.PlayerScreen
import com.albertolicea00.mivio.ui.source.SourceScreen

@Composable
fun MivioNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
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
        composable("sources") {
            SourceScreen()
        }
    }
}
