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
fun SentenceContent(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
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
        color = backgroundColor,
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                title = { Text("Sentence", fontWeight = FontWeight.Bold) },
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
                    text = "Sentence",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD32F2F),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Sentence के मुख्य दो वर्गीकरण हैं -",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.Black
                )

                // 1. Structure View
                ContentSection(title = "1. रचना की दृष्टि से (Structure)", titleColor = Color(0xFF1976D2)) {
                    val points = listOf(
                        "1. Simple sentence (साधारण वाक्य): इसमें एक ही subject और एक ही finite verb होती है |\nExample:\nHe reads a book.",
                        "2. Complex sentence (मिश्र वाक्य): इसमें एक Principal clause और कम से कम एक Subordinate clause होता है |\nExample:\nI know that he is honest.",
                        "3. Compound sentence (संयुक्त वाक्य): इसमें कम से कम दो independent clauses होते हैं जो Coordinating conjunction से जुड़े होते हैं |\nExample:\nHe is poor but he is honest."
                    )
                    points.forEachIndexed { index, point ->
                        ColoredPoint(text = point, index = index)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Meaning View
                ContentSection(title = "2. अर्थ की दृष्टि से (Meaning)", titleColor = Color(0xFF388E3C)) {
                    val types = listOf(
                        "1. Assertive Sentence (कथनात्मक वाक्य )",
                        "2. Interrogative sentence (प्रश्नवाचक वाक्य )",
                        "3. Imperative sentence (आज्ञा सूचक वाक्य )",
                        "4. Exclamatory sentence (विस्मय सूचक वाक्य )",
                        "5. Optative sentence (इच्छा सूचक वाक्य )"
                    )
                    types.forEachIndexed { index, type ->
                        ColoredPoint(text = type, index = index + 3)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Assertive Detail
                ContentSection(title = "1. Assertive Sentence", titleColor = Color(0xFFF57C00)) {
                    Text("ये दो प्रकार के होते है -", fontSize = 15.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                    ColoredPoint("(i). Affirmative sentence.\nEx: Ram goes to school.", 0)
                    ColoredPoint("(ii). Negative sentence.\nEx: Ram does not go to school.", 1)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Imperative Detail
                ContentSection(title = "3. Imperative Sentence (आज्ञा सूचक)", titleColor = Color(0xFF7B1FA2)) {
                    SubSectionTitle("Rule :-", Color(0xFF7B1FA2))
                    val rules = listOf(
                        "1. इसमें आज्ञा (order), प्रार्थना (request), या परामर्श (advice) का बोध होता है ।",
                        "2. Subject 'you' हमेशा छिपा रहता है ।",
                        "3. वाक्य verb के मूल रूप से प्रारम्भ होता है ।",
                        "4. प्रार्थना हेतु Please या Kindly लगाते हैं ।",
                        "5. 'Let' का प्रयोग प्रस्ताव या अनुमति हेतु होता है ।"
                    )
                    rules.forEachIndexed { index, rule ->
                        ColoredPoint(text = rule, index = index + 2)
                    }
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    ExampleItem("Examples:", "• Read good books.\n• Please lend me some money.\n• उसे घर जाने दो ।\n  Let him go home.\n• आओ हम बाजार चले ।\n  Let us go to the market.")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 5. Negative Imperative
                ContentSection(title = "Negative (Imperative)", titleColor = Color(0xFFC62828)) {
                    val negPoints = listOf(
                        "निषेध हेतु 'Do not' + V1 लगाते हैं ।",
                        "कभी नहीं के लिए 'Never' + V1 लगाते हैं ।"
                    )
                    negPoints.forEachIndexed { index, point ->
                        ColoredPoint(text = point, index = index + 4)
                    }
                    
                    ExampleItem("Examples:", "• Do not talk in the class.\n  (कक्षा मे बात चीत मत करो )\n• Never tell a lie.\n  ( कभी झूठ मत बोलो )")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 6. Exclamatory Detail
                ContentSection(title = "4. Exclamatory sentence (विस्मय सूचक)", titleColor = Color(0xFF1976D2)) {
                    val excRules = listOf(
                        "इसमें दुःख, हर्ष, या आश्चर्य का भाव होता है ।",
                        "विस्मयादिबोधक चिन्ह ( ! ) का प्रयोग अनिवार्य है ।",
                        "What या How से अधिकता प्रकट की जाती है ।"
                    )
                    excRules.forEachIndexed { index, rule ->
                        ColoredPoint(text = rule, index = index)
                    }
                    
                    ExampleItem("Examples:", "• वह कितना कमजोर है !\n  How weak he is !\n• अहा ! हम सब पास है ।\n  Ah! all of us have passed.")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 7. Optative Detail
                ContentSection(title = "5. Optative sentence (इच्छा सूचक)", titleColor = Color(0xFF388E3C)) {
                    ColoredPoint("इसमें ईश्वर से प्रार्थना या इच्छा प्रकट होती है । 'May' से प्रारम्भ होता है ।", 1)
                    
                    ExampleItem("Example:", "भगवान तुम्हें लंबी आयु दे !\nMay you live long !")
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SentencePreview() {
    GrammarTheme {
        SentenceContent()
    }
}
