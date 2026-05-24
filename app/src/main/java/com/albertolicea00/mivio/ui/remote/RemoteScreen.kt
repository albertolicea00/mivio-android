package com.albertolicea00.mivio.ui.remote

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SettingsRemote
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albertolicea00.mivio.ui.theme.BackgroundColor
import com.albertolicea00.mivio.ui.theme.BrandPrimary
import com.albertolicea00.mivio.ui.theme.MutedGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RemoteScreen() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Remote", fontWeight = FontWeight.Bold, color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundColor,
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = BackgroundColor
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.SettingsRemote,
                contentDescription = null,
                tint = BrandPrimary,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Connect to a TV or VR headset",
                color = MutedGray,
                fontSize = 16.sp
            )
        }
    }
}
