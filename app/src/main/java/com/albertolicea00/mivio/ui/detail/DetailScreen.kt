package com.albertolicea00.mivio.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(mediaId: String, onPlayClicked: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxWidth().height(250.dp).padding(16.dp)) {
            Text("Backdrop Image Placeholder")
        }
        
        Text("Movie Title", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(16.dp))
        Text("Synopsis: A great movie about AI building an app.", modifier = Modifier.padding(horizontal = 16.dp))
        
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onPlayClicked,
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        ) {
            Text("Play")
        }
    }
}
