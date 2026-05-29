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
fun DoublePartsContent(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
    val view = LocalView.current
    val primaryColor = MaterialTheme.colorScheme.primary
    val backgroundColor = Color(0xFFF8F9FA)

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = primaryColor.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Header
            TopAppBar(
                title = { Text("Double Parts of Speech", fontWeight = FontWeight.Bold) },
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
                // Main Intro Card with Names
                ContentSection(
                    title = "Double Parts of Speech",
                    titleColor = Color(0xFFD32F2F)
                ) {
                    Text(
                        text = "Double parts of speech refer to words that can act as two different parts of speech. There are three types:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    
                    val mainTypes = listOf(
                        "1. Infinitive (To + Verb): Acts as Noun + Verb.",
                        "2. Participle (Verb + ing/ed): Acts as Adjective + Verb.",
                        "3. Gerund (Verb + ing): Acts as Noun + Verb."
                    )
                    mainTypes.forEachIndexed { index, s ->
                        ColoredPoint(text = s, index = index)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 1. Infinitive Detail
                ContentSection(
                    title = "1. Infinitive",
                    titleColor = Color(0xFF1976D2),
                    content = {
                        Text("Description:", fontWeight = FontWeight.Bold, color = Color.Gray, fontSize = 14.sp)
                        Text(
                            text = "यह verb की first form के पहले 'To' लगाने से बनता है । यह दो प्रकार का होता है -",
                            fontSize = 16.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        
                        val infSubTypes = listOf(
                            "(i) Simple Infinitive (Use as Noun).",
                            "(ii) Gerundial Infinitive (Use as Adjective/Adverb)."
                        )
                        infSubTypes.forEachIndexed { index, s ->
                            ColoredPoint(text = s, index = index + 1)
                        }

                        Spacer(modifier = Modifier.height(12.dp))
                        SubSectionTitle("(i). Simple Infinitive Uses", Color(0xFF388E3C))
                        
                        val infTypes = listOf(
                            "a. Subject to a verb.\nExample:\nTo find fault is easy.",
                            "b. Object to a transitive verb.\nExample:\nI like to read.",
                            "c. Object to a preposition.\nExample:\nThe show is about to start.",
                            "d. Complement to a verb.\nExample:\nHis ambition is to lead.",
                            "e. Case in apposition.\nExample:\nIt is our duty to respect elders."
                        )
                        infTypes.forEachIndexed { index, text ->
                            ColoredPoint(text = text, index = index + 3)
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        RuleBox("Rule: कुछ verbs (like bid, let, make, see, hear) के बाद 'To' लुप्त (hidden) रहता है ।")
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Participle Detail
                ContentSection(
                    title = "2. Participle",
                    titleColor = Color(0xFFE64A19),
                    content = {
                        Text("Description:", fontWeight = FontWeight.Bold, color = Color.Gray, fontSize = 14.sp)
                        Text(
                            text = "यह verb का वह रूप है जो की verb तथा adjective दोनों का कार्य करता है । इसके 3 प्रकार है -",
                            fontSize = 16.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        val partTypes = listOf(
                            "(i) Present participle: (V1 + ing). यह जारी कार्य दिखाता है ।\nExample:\nI saw a flying bird.",
                            "(ii) Past participle: (V3). यह पूर्ण कार्य दिखाता है ।\nExample:\nHe is a tired man.",
                            "(iii) Perfect participle: (Having + V3). एक कार्य के बाद दूसरा शुरू होना ।\nExample:\nHaving finished the work, he went home."
                        )
                        partTypes.forEachIndexed { index, text ->
                            ColoredPoint(text = text, index = index)
                        }
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Gerund Detail
                ContentSection(
                    title = "3. Gerund",
                    titleColor = Color(0xFF7B1FA2),
                    content = {
                        Text("Description:", fontWeight = FontWeight.Bold, color = Color.Gray, fontSize = 14.sp)
                        Text(
                            text = "Gerund, verb में ing लगा कर बनता है और यह Noun का कार्य करता है ।",
                            fontSize = 16.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        val gerundUses = listOf(
                            "(a) Subject to a verb:\nWalking is a good exercise.",
                            "(b) Object to a verb:\nI love cooking.",
                            "(c) Object to a preposition:\nHe is afraid of swimming.",
                            "(d) Complement to a verb:\nWhat I hate most is cheating."
                        )
                        gerundUses.forEachIndexed { index, text ->
                            ColoredPoint(text = text, index = index + 3)
                        }
                    }
                )

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoublePartsPreview() {
    GrammarTheme {
        DoublePartsContent()
    }
}
