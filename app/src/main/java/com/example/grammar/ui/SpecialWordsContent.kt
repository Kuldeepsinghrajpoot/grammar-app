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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grammar.R
import com.example.grammar.ui.theme.GrammarTheme
import android.app.Activity
import androidx.core.view.WindowCompat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpecialWordsContent(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
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
                title = { Text("Special Words Usage", fontWeight = FontWeight.Bold) },
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
                    text = "Special Words",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD32F2F),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                )

                Text(
                    text = "Uses of some special words that often cause confusion:",
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // 1. Use of verb ‘To be’
                ContentSection(title = "Use of verb ‘To be’ (is, am, are, was, were)", titleColor = Color(0xFF1976D2)) {
                    val toBeRules = listOf(
                        "1. Be verb के कुल 5 part है - is, am, are (Present) तथा was, were (Past) ।",
                        "2. यह progressive tense बनाने मे प्रयोग होती है |\nExample:\nShe is going to school.",
                        "3. Passive voice बनाने मे |\nExample:\nA letter is being written by her.",
                        "4. कुछ वाक्यों मे be verb helping verb नहीं बल्कि main verb के रुप मे काम करती है |\nExample:\nThey are brave.\nIs he an honest man?",
                        "Note: be verb का progressive मे 'being' तथा participle मे 'been' होता है ।"
                    )
                    toBeRules.forEachIndexed { index, s -> ColoredPoint(text = s, index = index) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Introductory ‘It’
                ContentSection(title = "Use of introductory ‘It’", titleColor = Color(0xFF388E3C)) {
                    val itRules = listOf(
                        "1. जिन वाक्यों मे वास्तविक कर्ता (Subject) न हो उन वाक्यों मे It का प्रयोग होता है ।",
                        "2. समय, दिन, मौसम, वर्षा, प्राकृतिक घटना का वर्णन करने के लिए |\nExample:\nIt is 6 o’clock. (समय)\nIt is Sunday today. (दिन)\nIt is hot today. (मौसम)\nIt is raining heavily. (वर्षा)\nIt is growing dark. (प्राकृतिक घटना)",
                        "3. किसी बात पर जोर देने के लिए |\nExample:\nIt was I who did this work."
                    )
                    itRules.forEachIndexed { index, s -> ColoredPoint(text = s, index = index + 1) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Use of have
                ContentSection(title = "Use of have (has, have, had)", titleColor = Color(0xFFF57C00)) {
                    val haveRules = listOf(
                        "1. इस का प्रयोग Perfect tense बनाने मे किया जाता है |\nExample:\nHe has eaten a mango.",
                        "2. जब verb का अर्थ किसी वस्तु को अधिकार मे रखना (Possession) हो |\nExample:\nI have a pen.\nI had a car.",
                        "3. अधिकार के अर्थ मे Negative/Interrogative मे do, does, did का प्रयोग होता है |\nExample:\nDoes he have much money?",
                        "Note: कर्ता एवं Tense के अनुसार has, have, had, will have, shall have का प्रयोग होता है ।"
                    )
                    haveRules.forEachIndexed { index, s -> ColoredPoint(text = s, index = index + 2) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Introductory ‘There’
                ContentSection(title = "Use of introductory ‘There’", titleColor = Color(0xFF7B1FA2)) {
                    val thereRules = listOf(
                        "1. जिन वाक्यों मे किसी बात का होना या न होना पाया जाये और प्रकृतिक घटना न हो तो 'There' से प्रारंभ करते है ।",
                        "2. 'There' का अपना कोई अर्थ नहीं होता, इसे केवल introductory subject की तरह use करते है ।",
                        "3. 'There' के बाद verb (is, am, was, were) subject के अनुसार आती है |\nExample:\nThere are fifty boys in my class.\nWere there players in the field?\nOnce there was a cruel king.\nThere lived an old man in a village.\nThere will be no meeting in the hall."
                    )
                    thereRules.forEachIndexed { index, s -> ColoredPoint(text = s, index = index + 3) }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 5. ‘Have’ + ‘To’ infinitive
                ContentSection(title = "Use of ‘Have’ + ‘To’ infinitive", titleColor = Color(0xFFC62828)) {
                    val haveToRules = listOf(
                        "1. मज़बूरी (Compulsion) प्रकट करने के लिए Present मे 'has to/have to' तथा Past मे 'had to' का प्रयोग होता है ।",
                        "2. हिंदी अर्थ मे 'पड़ा, पड़ी, पड़े, पड़ता है, पड़ती है' आदि शब्द आते है |\nExample:\nउसे जाना पड़ता है |\nHe has to go.\n\nक्या आप को सुबह 4 बजे उठना पड़ता था ?\nDid you have to get up at 4 am?"
                    )
                    haveToRules.forEachIndexed { index, s -> ColoredPoint(text = s, index = index + 4) }
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpecialWordsPreview() {
    GrammarTheme {
        SpecialWordsContent()
    }
}
