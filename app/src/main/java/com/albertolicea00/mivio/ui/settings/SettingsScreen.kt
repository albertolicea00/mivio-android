package com.albertolicea00.mivio.ui.settings

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
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

private val BackgroundColor = Color(0xFF0C0D14)
private val BrandGold = Color(0xFFE5A93B)
private val SectionBackground = Color(0xFF191A23)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
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
                            .clickable { /* Navigate to MultiAccounts */ }
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Profile",
                            modifier = Modifier.size(60.dp),
                            tint = BrandGold.copy(alpha = 0.8f)
                        )
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("Default Profile", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text("Manage Accounts", fontSize = 14.sp, color = BrandGold)
                        }
                    }
                }
            }

            // Section 2: App Preferences
            item {
                SettingsSectionHeader("App Preferences")
                SettingsSection {
                    SettingsRow(icon = Icons.Default.Palette, color = Color(0xFF3F51B5), title = "Appearance") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.Security, color = Color(0xFF2196F3), title = "Privacy") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.Refresh, color = BrandGold, title = "Rescan Library") {
                        showingRescanAlert = true
                    }
                }
            }

            // Section 3: Library & Sources
            item {
                SettingsSectionHeader("Library & Sources")
                SettingsSection {
                    SettingsRow(icon = Icons.Default.AddCircle, color = BrandGold, title = "Add Files") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.LibraryBooks, color = Color(0xFF009688), title = "Library") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.Sync, color = Color(0xFF4CAF50), title = "Sync") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.Image, color = Color(0xFFE91E63), title = "Metadata & Artwork") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.CollectionsBookmark, color = Color(0xFFFF9800), title = "Collection & Groups") { /* Navigate */ }
                }
            }

            // Section 4: Playback Experience
            item {
                SettingsSectionHeader("Playback Experience")
                SettingsSection {
                    SettingsRow(icon = Icons.Default.PlayCircleFilled, color = Color(0xFFF44336), title = "Playback") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.VolumeUp, color = Color(0xFF00BCD4), title = "Audio") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.Tv, color = Color(0xFF2196F3), title = "Video") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.Subtitles, color = Color(0xFFFFEB3B), title = "Subtitles") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.Language, color = Color(0xFF009688), title = "Language") {
                        context.startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
                    }
                }
            }

            // Section 5: Network & Experimental
            item {
                SettingsSectionHeader("Network & Experimental")
                SettingsSection {
                    SettingsRow(icon = Icons.Default.Cast, color = Color(0xFF3F51B5), title = "Casting") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.NetworkWifi, color = Color(0xFF9E9E9E), title = "Network") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.Science, color = Color(0xFF00BFA5), title = "Lab") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.FamilyRestroom, color = Color(0xFFFF9800), title = "Parental Control") { /* Navigate */ }
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
                    SettingsRow(icon = Icons.Default.BugReport, color = Color(0xFFF44336), title = "Report a Bug") { /* Navigate */ }
                    LinkRow(icon = Icons.Default.Star, color = Color(0xFFFFEB3B), title = "Rate Mivio", url = "https://play.google.com/store/apps/details?id=com.albertolicea00.mivio")
                    LinkRow(icon = Icons.Default.Share, color = Color(0xFF2196F3), title = "Tell a Friend", url = "https://mivio.app")
                    SettingsRow(icon = Icons.Default.ChatBubble, color = Color(0xFF00BCD4), title = "Follow Us") { /* Navigate */ }
                    SettingsRow(icon = Icons.Default.Favorite, color = Color(0xFFE91E63), title = "Make a Donation") { /* Navigate */ }
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
                    TextButton(onClick = { showingRescanAlert = false }) { Text("Scan", color = BrandGold) }
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
