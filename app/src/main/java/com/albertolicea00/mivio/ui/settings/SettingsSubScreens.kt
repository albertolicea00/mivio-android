package com.albertolicea00.mivio.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.albertolicea00.mivio.ui.theme.BackgroundColor
import com.albertolicea00.mivio.ui.theme.BrandPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseSettingsSubScreen(navController: NavController, title: String, content: @Composable ColumnScope.() -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title, fontWeight = FontWeight.Bold, color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = BrandPrimary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundColor,
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = BackgroundColor
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            content()
        }
    }
}

@Composable
fun SettingsDetailPlaceholderScreen(navController: NavController, title: String) {
    BaseSettingsSubScreen(navController = navController, title = title) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = null,
                tint = BrandPrimary.copy(alpha = 0.7f),
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(title, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Configuration options for $title will go here.",
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
        }
    }
}

@Composable
fun AppearanceSettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Appearance")

@Composable
fun PrivacySettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Privacy")

@Composable
fun MultiAccountSettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Manage Accounts")

@Composable
fun LibrarySettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Library")

@Composable
fun SyncSettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Sync")

@Composable
fun CollectionsSettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Collections")

@Composable
fun MetadataSettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Metadata & Artwork")

@Composable
fun PlaybackSettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Playback")

@Composable
fun AudioSettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Audio")

@Composable
fun VideoSettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Video")

@Composable
fun SubtitleSettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Subtitles")

@Composable
fun CastingSettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Casting")

@Composable
fun NetworkSettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Network")

@Composable
fun LabSettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Lab")

@Composable
fun ParentalControlSettingsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Parental Control")

@Composable
fun ReportBugScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Report a Bug")

@Composable
fun FollowUsScreen(navController: NavController) = SettingsDetailPlaceholderScreen(navController, "Follow Us")
