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
                    text = "sentence दो प्रकार के होते है -",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.Black
                )

                // 1. Structure View
                ContentSection(title = "1. रचना की दृष्टि से sentence :-", titleColor = Color(0xFF1976D2)) {
                    Text("रचना की दृष्टि से sentence तीन प्रकार के होते है -", fontSize = 15.sp, color = Color.DarkGray, modifier = Modifier.padding(bottom = 8.dp))
                    val points = listOf(
                        "1. Simple sentence. (साधारण वाक्य )",
                        "2. Complex sentence. (मिश्र वाक्य )",
                        "3. Compound sentence. (संयुक्त वाक्य )"
                    )
                    points.forEachIndexed { index, point ->
                        ColoredPoint(text = point, index = index)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Meaning View
                ContentSection(title = "2. अर्थ की दृष्टि से sentence :-", titleColor = Color(0xFF388E3C)) {
                    Text("अर्थ की दृष्टि से वाक्य 5 प्रकार के होते है -", fontSize = 15.sp, color = Color.DarkGray, modifier = Modifier.padding(bottom = 8.dp))
                    val types = listOf(
                        "1. Assertive Sentence (Simple sentence).",
                        "2. Interrogative sentence.",
                        "3. Imperative sentence. (आज्ञा सूचक वाक्य )",
                        "4. Exclamatory sentence. (विस्मय सूचक वाक्य )",
                        "5. Optative sentence. (इच्छा सूचक वाक्य )"
                    )
                    types.forEachIndexed { index, type ->
                        ColoredPoint(text = type, index = index + 3)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Assertive Detail
                ContentSection(title = "1. Assertive Sentence (Simple sentence.):-", titleColor = Color(0xFFF57C00)) {
                    Text("simple sentence दो प्रकार के होते है -", fontSize = 15.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                    ColoredPoint("(i). Affirmative sentence.", 0)
                    ColoredPoint("(ii). Negative sentence.", 1)
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    RuleBox("Note:- Affirmative , Negative तथा Interrogative का अध्ययन tense बाले भाग मे है |")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Imperative Detail
                ContentSection(title = "3. Imperative Sentence :-", titleColor = Color(0xFF7B1FA2)) {
                    SubSectionTitle("Rule :-", Color(0xFF7B1FA2))
                    val rules = listOf(
                        "1. Imperative sentence से आज्ञा (order command), प्रार्थना (request), परामर्श (advice) या किसी से कुछ कहने के लिए, का बोध होता है ।",
                        "2. ऐसे Sentence मे subject 'you' छिपा रहता है ।",
                        "3. इस प्रकार के वाक्यों मे verb अपने मूल रूप का ही प्रयोग करती है और उसे वाक्य के प्रारम्भ मे लिखते है ।\nExample:\n• Read good books.\n• Bring me a cup of hot tea.\n• Respect your parents and elders.",
                        "4. प्रार्थना वाले वाक्यों मे कृपया या कृपा करके लगा रहता है जिन की अंग्रेजी 'Please' होती है ।\nExample:\n• Please lend me 50 rupees.\n• Please tell me your name.",
                        "5. यदि वाक्य मे vocative case का noun है तो वह sentence के प्रारम्भ मे या अंत मे use किया जा सकता है ।\nExample:\nMohan, stand up on the table.",
                        "6. जहाँ सुझाव या प्रस्ताव का भाव हो तो वहाँ 'let' का प्रयोग किया जाता है । यदि वाक्य के अंत मे 'दो' शब्द आया हो तो 'let' से बनाते है ।\nExample:\n• उसे घर जाने दो |\n  Let him go home.\n• आओ हम बाजार चले |\n  Let us go to the market."
                    )
                    rules.forEachIndexed { index, rule ->
                        ColoredPoint(text = rule, index = index + 2)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 5. Negative Imperative
                ContentSection(title = "Negative Sentence (Imperative) :-", titleColor = Color(0xFFC62828)) {
                    val negPoints = listOf(
                        "अगर वाक्य मे 'मत' या 'न' आया हो तो सबसे पहले 'do not' लगाते है इस के बाद verb की first form आती है ।",
                        "यदि वाक्य मे 'कभी मत' या 'कभी न' आया हो तो उस के लिए 'never' लगा कर verb की first form लगाते है ।"
                    )
                    negPoints.forEachIndexed { index, point ->
                        ColoredPoint(text = point, index = index + 4)
                    }
                    
                    ExampleItem("Examples:", "• Do not talk in the class.\n  (कक्षा मे बात चीत मत करो )\n• Never tell a lie.\n  ( कभी झूठ मत बोलो )")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 6. Exclamatory Detail
                ContentSection(title = "4. Exclamatory sentence (विस्मय सूचक वाक्य ) :-", titleColor = Color(0xFF1976D2)) {
                    Text("इस प्रकार के वाक्यों मे दुःख, प्रसन्नता, दया, क्रोध, आश्चर्य आदि भाव होते है ।", fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
                    val excRules = listOf(
                        "इन वाक्यों के अंत मे प्रायः सम्बोधन का चिन्ह ( ! ) लगता है ।",
                        "वाक्यों के साथ alas, ah, hurrah आदि interjection का भी प्रयोग करते है ।",
                        "इन वाक्यों से 'कितना', 'कैसा' के प्रयोग से अधिकता प्रकट होती है । इन शब्दो के अनुवाद के लिए वाक्य के प्रारम्भ मे what या how का प्रयोग किया जाता है ।"
                    )
                    excRules.forEachIndexed { index, rule ->
                        ColoredPoint(text = rule, index = index)
                    }
                    
                    ExampleItem("Examples:", "• वह कितना कमजोर है !\n  How weak he is !\n• तुम कितने चतुर लड़के हो !\n  What a clever boy you are.\n• अहा ! हम सब पास है |\n  Ah! all of us have passed.")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 7. Optative Detail
                ContentSection(title = "5. Optative sentence (इच्छा सूचक वाक्य ) :-", titleColor = Color(0xFF388E3C)) {
                    ColoredPoint("ईश्वर से प्रार्थना अथवा इच्छा प्रकट करने वाले वाक्यों को Optative (इच्छा सूचक) कहते है । इन वाक्यों को 'may' से प्रारंभ करते है तथा वाक्य के अंत मे चिन्ह ( ! ) लगाते है ।", 1)
                    
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
