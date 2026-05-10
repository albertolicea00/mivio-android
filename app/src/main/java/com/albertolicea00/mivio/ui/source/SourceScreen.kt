package com.albertolicea00.mivio.ui.source

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SourceScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Manage Sources") }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Current Sources:")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Add new source */ }) {
                Text("Add SMB/WebDAV Source")
            }
        }
    }
}
