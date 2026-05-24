package com.albertolicea00.mivio.ui.source

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SourceScreen() {
    val backgroundColor = Color(0xFF0C0D14)
    val brandPrimary = Color(0xFFF14911)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Manage Sources", fontWeight = FontWeight.Bold, color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backgroundColor,
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = backgroundColor
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val mutedGray = Color(0xFF7E8494)
            Icon(
                imageVector = Icons.Default.Folder,
                contentDescription = null,
                tint = brandPrimary,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Add SMB, WebDAV or local files",
                color = mutedGray,
                fontSize = 16.sp
            )
        }
    }
}
