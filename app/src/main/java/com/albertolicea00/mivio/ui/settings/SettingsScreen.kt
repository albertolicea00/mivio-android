package com.albertolicea00.mivio.ui.settings

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.albertolicea00.mivio.ui.theme.BackgroundColor
import com.albertolicea00.mivio.ui.theme.BrandPrimary
import com.albertolicea00.mivio.ui.theme.SectionBackground

@Composable
fun SettingsScreen() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { SettingsMainScreen(navController) }
        composable("appearance") { AppearanceSettingsScreen(navController) }
        composable("privacy") { PrivacySettingsScreen(navController) }
        composable("multiaccount") { MultiAccountSettingsScreen(navController) }
        composable("library") { LibrarySettingsScreen(navController) }
        composable("sync") { SyncSettingsScreen(navController) }
        composable("metadata") { MetadataSettingsScreen(navController) }
        composable("collections") { CollectionsSettingsScreen(navController) }
        composable("playback") { PlaybackSettingsScreen(navController) }
        composable("audio") { AudioSettingsScreen(navController) }
        composable("video") { VideoSettingsScreen(navController) }
        composable("subtitles") { SubtitleSettingsScreen(navController) }
        composable("casting") { CastingSettingsScreen(navController) }
        composable("network") { NetworkSettingsScreen(navController) }
        composable("lab") { LabSettingsScreen(navController) }
        composable("parental") { ParentalControlSettingsScreen(navController) }
        composable("reportbug") { ReportBugScreen(navController) }
        composable("followus") { FollowUsScreen(navController) }
        composable("addfiles") { SettingsDetailPlaceholderScreen(navController, "Add Files") }
        composable("donation") { SettingsDetailPlaceholderScreen(navController, "Donation") }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsMainScreen(navController: NavController) {
    val context = LocalContext.current
    var showingRescanAlert by remember { mutableStateOf(false) }
    var showingResetAlert by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings", fontWeight = FontWeight.Bold, color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundColor,
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = BackgroundColor
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item { Spacer(modifier = Modifier.height(8.dp)) }

            // Section 1: Top Profile Card (Multi-Accounts)
            item {
                SettingsSection {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { navController.navigate("multiaccount") }
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Profile",
                            modifier = Modifier.size(60.dp),
                            tint = BrandPrimary.copy(alpha = 0.8f)
                        )
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("Default Profile", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text("Manage Accounts", fontSize = 14.sp, color = BrandPrimary)
                        }
                    }
                }
            }

            // Section 2: App Preferences
            item {
                SettingsSectionHeader("App Preferences")
                SettingsSection {
                    SettingsRow(icon = Icons.Default.Palette, color = Color(0xFF3F51B5), title = "Appearance") { navController.navigate("appearance") }
                    SettingsRow(icon = Icons.Default.Security, color = Color(0xFF2196F3), title = "Privacy") { navController.navigate("privacy") }
                    SettingsRow(icon = Icons.Default.Refresh, color = BrandPrimary, title = "Rescan Library") {
                        showingRescanAlert = true
                    }
                }
            }

            // Section 3: Library & Sources
            item {
                SettingsSectionHeader("Library & Sources")
                SettingsSection {
                    SettingsRow(icon = Icons.Default.AddCircle, color = BrandPrimary, title = "Add Files") { navController.navigate("addfiles") }
                    SettingsRow(icon = Icons.Default.LibraryBooks, color = Color(0xFF009688), title = "Library") { navController.navigate("library") }
                    SettingsRow(icon = Icons.Default.Sync, color = Color(0xFF4CAF50), title = "Sync") { navController.navigate("sync") }
                    SettingsRow(icon = Icons.Default.Image, color = Color(0xFFE91E63), title = "Metadata & Artwork") { navController.navigate("metadata") }
                    SettingsRow(icon = Icons.Default.CollectionsBookmark, color = Color(0xFFFF9800), title = "Collection & Groups") { navController.navigate("collections") }
                }
            }

            // Section 4: Playback Experience
            item {
                SettingsSectionHeader("Playback Experience")
                SettingsSection {
                    SettingsRow(icon = Icons.Default.PlayCircleFilled, color = Color(0xFFF44336), title = "Playback") { navController.navigate("playback") }
                    SettingsRow(icon = Icons.Default.VolumeUp, color = Color(0xFF00BCD4), title = "Audio") { navController.navigate("audio") }
                    SettingsRow(icon = Icons.Default.Tv, color = Color(0xFF2196F3), title = "Video") { navController.navigate("video") }
                    SettingsRow(icon = Icons.Default.Subtitles, color = Color(0xFFFFEB3B), title = "Subtitles") { navController.navigate("subtitles") }
                    SettingsRow(icon = Icons.Default.Language, color = Color(0xFF009688), title = "Language") {
                        context.startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
                    }
                }
            }

            // Section 5: Network & Experimental
            item {
                SettingsSectionHeader("Network & Experimental")
                SettingsSection {
                    SettingsRow(icon = Icons.Default.Cast, color = Color(0xFF3F51B5), title = "Casting") { navController.navigate("casting") }
                    SettingsRow(icon = Icons.Default.NetworkWifi, color = Color(0xFF9E9E9E), title = "Network") { navController.navigate("network") }
                    SettingsRow(icon = Icons.Default.Science, color = Color(0xFF00BFA5), title = "Lab") { navController.navigate("lab") }
                    SettingsRow(icon = Icons.Default.FamilyRestroom, color = Color(0xFFFF9800), title = "Parental Control") { navController.navigate("parental") }
                    SettingsRow(icon = Icons.Default.SettingsBackupRestore, color = Color(0xFFF44336), title = "Reset All Settings", titleColor = Color(0xFFF44336)) {
                        showingResetAlert = true
                    }
                }
            }

            // Section 6: Support & Community
            item {
                SettingsSectionHeader("Support & Community")
                SettingsSection {
                    LinkRow(icon = Icons.Default.HelpCenter, color = Color(0xFF3F51B5), title = "Help Center", url = "https://mivio.app/help")
                    SettingsRow(icon = Icons.Default.BugReport, color = Color(0xFFF44336), title = "Report a Bug") { navController.navigate("reportbug") }
                    LinkRow(icon = Icons.Default.Star, color = Color(0xFFFFEB3B), title = "Rate Mivio", url = "https://play.google.com/store/apps/details?id=com.albertolicea00.mivio")
                    ShareRow(icon = Icons.Default.Share, color = Color(0xFF2196F3), title = "Tell a Friend", text = "Check out Mivio, the ultimate media player! https://mivio.app")
                    SettingsRow(icon = Icons.Default.ChatBubble, color = Color(0xFF00BCD4), title = "Follow Us") { navController.navigate("followus") }
                    SettingsRow(icon = Icons.Default.Favorite, color = Color(0xFFE91E63), title = "Make a Donation") { navController.navigate("donation") }
                }
            }

            // Section 7: About
            item {
                SettingsSectionHeader("About")
                SettingsSection {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("Version", color = Color.White)
                            Text("1.0.0 (1)", color = Color.Gray)
                        }
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("Developer", color = Color.White)
                            Text("Alberto Licea", color = Color.Gray)
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(32.dp)) }
        }

        // Dialogs
        if (showingRescanAlert) {
            AlertDialog(
                onDismissRequest = { showingRescanAlert = false },
                title = { Text("Rescan Library") },
                text = { Text("This will look for new files and update metadata.") },
                confirmButton = {
                    TextButton(onClick = { showingRescanAlert = false }) { Text("Scan", color = BrandPrimary) }
                },
                dismissButton = {
                    TextButton(onClick = { showingRescanAlert = false }) { Text("Cancel", color = Color.Gray) }
                },
                containerColor = SectionBackground,
                titleContentColor = Color.White,
                textContentColor = Color.LightGray
            )
        }

        if (showingResetAlert) {
            AlertDialog(
                onDismissRequest = { showingResetAlert = false },
                title = { Text("Reset Settings") },
                text = { Text("This will restore all default preferences. Your library will not be affected.") },
                confirmButton = {
                    TextButton(onClick = { showingResetAlert = false }) { Text("Reset", color = Color(0xFFF44336)) }
                },
                dismissButton = {
                    TextButton(onClick = { showingResetAlert = false }) { Text("Cancel", color = Color.Gray) }
                },
                containerColor = SectionBackground,
                titleContentColor = Color.White,
                textContentColor = Color.LightGray
            )
        }
    }
}

@Composable
fun SettingsSectionHeader(title: String) {
    Text(
        text = title,
        color = Color.LightGray,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(bottom = 8.dp, start = 16.dp)
    )
}

@Composable
fun SettingsSection(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(SectionBackground)
    ) {
        content()
    }
}

@Composable
fun SettingsRow(
    icon: ImageVector,
    color: Color,
    title: String,
    titleColor: Color = Color.White,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(18.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            color = titleColor,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun LinkRow(
    icon: ImageVector,
    color: Color,
    title: String,
    url: String
) {
    val context = LocalContext.current
    SettingsRow(
        icon = icon,
        color = color,
        title = title,
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        }
    )
}

@Composable
fun ShareRow(
    icon: ImageVector,
    color: Color,
    title: String,
    text: String
) {
    val context = LocalContext.current
    SettingsRow(
        icon = icon,
        color = color,
        title = title,
        onClick = {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, text)
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            context.startActivity(shareIntent)
        }
    )
}
