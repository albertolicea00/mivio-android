package com.albertolicea00.mivio.ui.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onNavigateToSources: () -> Unit) {
    val backgroundColor = Color(0xFF0C0D14)
    val brandPrimary = Color(0xFFF14911)
    val mutedGray = Color(0xFF7E8494)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Your Library", fontWeight = FontWeight.Bold, color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backgroundColor,
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = backgroundColor
    ) { paddingValues ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val isWideScreen = maxWidth >= 600.dp

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {

            // ----------------------------------------------------
            // 3. Centered Empty State
            // ----------------------------------------------------
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(bottom = 64.dp) // Offset slightly upwards for perfect visual balance
                ) {
                    // Popcorn Canvas Icon
                    PopcornCanvasIcon(
                        color = brandPrimary,
                        bgColor = backgroundColor,
                        modifier = Modifier.size(120.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "No Media Discovered",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    // Description text with clickable Sources word
                    val annotatedText = buildAnnotatedString {
                        append("Connect local, SMB, or WebDAV folders in ")
                        pushStringAnnotation(tag = "sources", annotation = "sources")
                        withStyle(
                            style = SpanStyle(
                                color = brandPrimary,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.None
                            )
                        ) {
                            append("Sources")
                        }
                        pop()
                        append(" to populate your library.")
                    }

                    ClickableText(
                        text = annotatedText,
                        style = TextStyle(
                            color = mutedGray,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 20.sp
                        ),
                        modifier = Modifier.width(320.dp),
                        onClick = { offset ->
                            annotatedText.getStringAnnotations(tag = "sources", start = offset, end = offset)
                                .firstOrNull()?.let {
                                    onNavigateToSources()
                                }
                        }
                    )
                }
            }
        }
    }
}
}

@Composable
fun PopcornCanvasIcon(
    color: Color,
    bgColor: Color,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val strokeWidth = 3.dp.toPx()

        // 1. Draw Popcorn fluffy tops as overlapping filled circles, then draw outlines.
        // We fill them with background color first to act as mask and keep clean outlines.
        val popcornCircles = listOf(
            Offset(w * 0.35f, h * 0.32f) to w * 0.12f,
            Offset(w * 0.47f, h * 0.22f) to w * 0.13f,
            Offset(w * 0.58f, h * 0.25f) to w * 0.12f,
            Offset(w * 0.65f, h * 0.34f) to w * 0.11f
        )

        // Fill background color
        popcornCircles.forEach { (center, radius) ->
            drawCircle(color = bgColor, radius = radius, center = center)
        }

        // Draw outlines
        popcornCircles.forEach { (center, radius) ->
            drawCircle(
                color = color,
                radius = radius,
                center = center,
                style = Stroke(width = strokeWidth)
            )
        }

        // 2. Draw Popcorn bucket (trapezoid outline)
        val bucketPath = Path().apply {
            moveTo(w * 0.32f, h * 0.42f)
            lineTo(w * 0.38f, h * 0.85f)
            lineTo(w * 0.62f, h * 0.85f)
            lineTo(w * 0.68f, h * 0.42f)
            quadraticBezierTo(x1 = w * 0.50f, y1 = h * 0.47f, x2 = w * 0.32f, y2 = h * 0.42f)
        }

        // Fill with background color to mask any popcorn details hanging underneath
        drawPath(path = bucketPath, color = bgColor)
        
        // Draw the bucket outline
        drawPath(
            path = bucketPath,
            color = color,
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round, join = StrokeJoin.Round)
        )

        // 3. Draw vertical stripes inside the bucket
        val stripe1 = Path().apply {
            moveTo(w * 0.41f, h * 0.44f)
            lineTo(w * 0.44f, h * 0.85f)
        }
        val stripe2 = Path().apply {
            moveTo(w * 0.50f, h * 0.45f)
            lineTo(w * 0.50f, h * 0.85f)
        }
        val stripe3 = Path().apply {
            moveTo(w * 0.59f, h * 0.44f)
            lineTo(w * 0.56f, h * 0.85f)
        }

        listOf(stripe1, stripe2, stripe3).forEach { path ->
            drawPath(path = path, color = color, style = Stroke(width = strokeWidth))
        }

        // 4. Draw Plus badge circle at the bottom-right (X=0.68, Y=0.81)
        val plusCenter = Offset(w * 0.68f, h * 0.81f)
        val plusRadius = w * 0.12f

        // Fill background color to mask bucket outline underneath
        drawCircle(color = bgColor, radius = plusRadius, center = plusCenter)
        
        // Draw golden outline for the plus circle
        drawCircle(
            color = color,
            radius = plusRadius,
            center = plusCenter,
            style = Stroke(width = strokeWidth)
        )

        // Draw cross lines inside the plus circle
        val crossLen = plusRadius * 0.5f
        drawLine(
            color = color,
            start = Offset(plusCenter.x - crossLen, plusCenter.y),
            end = Offset(plusCenter.x + crossLen, plusCenter.y),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            color = color,
            start = Offset(plusCenter.x, plusCenter.y - crossLen),
            end = Offset(plusCenter.x, plusCenter.y + crossLen),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
    }
}
