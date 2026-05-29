package com.example.grammar.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grammar.R
import com.example.grammar.ui.theme.GrammarTheme
import android.app.Activity
import androidx.core.view.WindowCompat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrepositionContent(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
    val view = LocalView.current
    val primaryColor = MaterialTheme.colorScheme.primary
    
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = primaryColor.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFFF8F9FA)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                title = { Text("The Preposition", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = primaryColor,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                // Main Header
                Text(
                    text = "The Preposition",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD32F2F),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "जो शब्द Noun या Pronoun के पहले लगकर उनका सम्बन्ध दूसरे शब्दों से बताते हैं, Preposition कहलाते हैं ।",
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 24.dp),
                    color = Color.DarkGray
                )

                // Common Prepositions list
                ContentSection(title = "Common Prepositions", titleColor = Color(0xFF1976D2)) {
                    val prepositions = listOf(
                        "• In: अंदर", "• On: ऊपर", "• At: पर/निकट",
                        "• To: को/तक", "• By: द्वारा", "• With: साथ",
                        "• For: के लिए", "• From: से", "• Of: का/की/के",
                        "• Under: नीचे", "• Between: बीच में (दो के)", "• Among: बीच में (दो से अधिक)"
                    )
                    prepositions.chunked(2).forEach { row ->
                        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                            row.forEach { item ->
                                Text(item, modifier = Modifier.weight(1f), fontSize = 15.sp, color = Color.Black)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Usage Rules
                ContentSection(title = "Usage Rules", titleColor = Color(0xFF388E3C)) {
                    val rules = listOf(
                        "1. Preposition के बाद हमेशा Objective Case का प्रयोग होता है |\nExample:\nHe is with me. (Not 'with I')",
                        "2. In और At: बड़े स्थानों के लिए 'In' और छोटे स्थानों के लिए 'At' लगाते हैं |\nExample:\nI live in India at Nowgong.",
                        "3. Between और Among: दो के लिए 'Between' और दो से अधिक के लिए 'Among' लगाते हैं |\nExample:\nDistribute these pens between Ram and Shyam.\nDistribute these sweets among all boys.",
                        "4. Beside और Besides: 'Beside' का अर्थ 'निकट' और 'Besides' का अर्थ 'अतिरिक्त' होता है |\nExample:\nGo and sit beside him.\nBesides Hindi, he knows English."
                    )
                    rules.forEachIndexed { index, rule ->
                        ColoredPoint(text = rule, index = index)
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrepositionPreview() {
    GrammarTheme {
        PrepositionContent()
    }
}
